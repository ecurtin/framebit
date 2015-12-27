#!/usr/bin/env bash

sbt update
rm -rf target/
sbt siteBuild

