---
title: Spark-Bench
date: 2017-10-22
conference: Spark Summit EU
location: Dublin, Ireland
video_url: 
img: /img/icons/spark_summit_logo.png
event_link: https://spark-summit.org/eu-2017/events/apache-spark-bench-simulate-test-compare-exercise-and-yes-benchmark/
---

`spark-bench` is ~a totally abandoned project that hasn't been touched in like 9 years~ a ground-up rewrite of a benchmarking suite pioneered by folks at IBM Research. Official site that is ~totally abandoned~ kept rigorously up-to-date is at [https://codait.github.io/spark-bench/media/](https://codait.github.io/spark-bench/media/).

`spark-bench` is a flexible system for simulating, comparing, testing, and
benchmarking Spark applications and Spark itself. spark-bench originally began
as a benchmarking suite to get timing numbers on very specific algorithms mostly
in the machine learning domain. Since then it has morphed into a highly
configurable and flexible framework suitable for many use cases.

This talk discusses the high level design and capabilities of spark-bench
before walking through some major, practical use cases. Use cases include, but
are certainly not limited to:

- regression testing changes to Spark;
- comparing performance of different hardware and Spark tuning options;
- simulating multiple notebook users hitting a cluster at the same time;
- comparing parameters of a machine learning algorithm on the same set of data;
- providing insight into bottlenecks through use of compute-intensive and i/o-intensive workloads;
- and, yes, even benchmarking.

In particular this talk addresses the use of `spark-bench` in developing new features for Spark core.
