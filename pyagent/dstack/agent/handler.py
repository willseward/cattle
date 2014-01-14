import re

from dstack import utils
from dstack.lock import lock


class BaseHandler(object):
    def __init__(self):
        pass

    def supports(self, req):
        method = self._get_method_for(req)

        if method is None:
            return False

        return self._check_supports(req)

    def execute(self, req):
        method = self._get_method_for(req)
        return method(req=req, **req.data.__dict__)

    def _get_method_for(self, req):
        prefix = self._get_handler_category(req) + "."
        if len(req.name) <= len(prefix):
            return None

        name = req.name[len(prefix):].replace(".", "_")
        idx = name.find(";")
        if idx != -1:
            name = name[0:idx]

        try:
            return getattr(self, name)
        except:
            return None

    def _reply(self, req, response_data):
        resp = utils.reply(req)
        resp.data = response_data

        return resp

    def _do(self, req=None, check=None, result=None, lock_obj=None, action=None):
        if check():
            return self._reply(req, result())

        with lock(lock_obj):
            if check():
                return self._reply(req, result())

            action()

            data = result()

            if not check():
                raise Exception("Operation failed")

            return self._reply(req, data)

    def _get_response_data(self, obj):
        type = obj.get("type")
        if type is not None:
            method_name = "_get_{0}_data".format(re.sub("([A-Z])", r'_\1', type)).lower()
            try:
                return getattr(self, method_name)(obj)
            except AttributeError:
                pass

        return {}

    def _check_supports(self, req):
        raise Exception("Not implemented")

    def _get_handler_category(self, req):
        raise Exception("Not implemented")


class KindBasedMixin(object):
    CHECK_PATHS = [
        ["imageStoragePoolMap", "storagePool", "kind"],
        ["volumeStoragePoolMap", "storagePool", "kind"],
        ["instanceHostMap", "host", "kind"],
    ]

    def __init__(self, kind=None):
        super(KindBasedMixin, self).__init__()
        self._kind = kind

    def _check_supports(self, req):
        for check in KindBasedMixin.CHECK_PATHS:
            val = req.data
            try:
                for part in check:
                    val = val[part]

                if val == self._kind:
                    return True
            except KeyError:
                pass

        return False
