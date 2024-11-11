#!/usr/bin/env bash

set -e

sudo docker compose down
sudo docker compose up --build
