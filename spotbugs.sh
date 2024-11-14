#!/usr/bin/env bash

set -e

./spotbugs-4.8.6/bin/spotbugs -textui \
    -html -output spotbugs.html \
    -effort:max \
    -progress \
    -sourcepath ./Tourism/src/main \
    ./Tourism/classes
