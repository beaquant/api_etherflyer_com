#!/usr/bin/python
# -*- coding: utf-8 -*-
"""
Created by bu on 2017-05-10
"""
from __future__ import unicode_literals
import json as complex_json
import requests
from utils import verify_sign
from utils import get_sign


class RequestClient(object):
    __headers = {
        'Content-Type': 'application/json; charset=utf-8',
        'Accept': 'application/json'
    }

    def __init__(self, access_id, secret_key, headers=dict()):
        self.access_id = access_id
        self.secret_key = secret_key
        self.headers = self.__headers
        self.headers.update(headers)

    def set_authorization(self, params):
        params['access_id'] = self.access_id
        self.headers['access_id'] = self.access_id
        self.headers['AUTHORIZATION'] = get_sign(params, self.secret_key)

    def request(self, method, url, params=dict(), data='', json=dict()):
        method = method.upper()
        if method == 'GET':
            self.set_authorization(params)
            result = requests.request('GET', url, params=params, headers=self.headers)
        else:
            if data:
                json.update(complex_json.loads(data))
            self.set_authorization(json)
            result = requests.request(method, url, json=json, headers=self.headers)
        return result

