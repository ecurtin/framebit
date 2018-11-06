Template: tech-page
Title: Code: Spark-Bench
Date: 2017-09-20
Tags: tech
Description: Benchmarking & simulation for Apache Spark
Img: ../images/icons/GitHub-Mark-120px-plus.png
Redirect: https://sparktc.github.io/spark-bench/

Spark-Bench is a ground-up rewrite I did of a benchmarking suite pioneered by folks at IBM Research.

While researchers are great at researching, they also have a strong affinity for bash and Java.
The ground up rewrite moved multiple independent maven projects into one, central Scala project built using SBT.
All configuration was moved from a scattering of bash variables to one, centralized config file.

Spark-bench is now more than just a benchmarking suite: it's a flexible platform for simulation and comparison of Spark use cases of all sorts.
