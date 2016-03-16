#!/usr/bin/env bash

time curl -X POST 'http://localhost:8083/druid/v2/?pretty' -H 'content-type: application/json' -d@$1

