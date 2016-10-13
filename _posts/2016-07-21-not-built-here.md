---
layout: post
title:  "Didn't Build It Here: Moving to Jekyll"
date:   2016-07-21 11:22:00 -0400
categories: code website
---

I've been through so many half-ass iterations on this poor website. Bless its heart.

I had more whole-ass implementations back in the day, starting with iWeb. Gotta love those skeuomorphic themes.

Then, after realizing there were reasons why serious people didn't do iWeb, I moved to Wordpress and felt pretty
cool for have conquered the technical curve of getting that going.

Oh, and there was a really brief time where I was trying to learn Drupal, but I fat finger deleted some file
with my not-so-pro terminal skills at the time, and my memory of the event was that everything on the screen went black. I don't think
that actually happened, but I'll stick with that emotional picture.

Wordpress lasted a good long while. I deleted my fair share of spam comments before I got rid of comments all together.
I changed themes a couple of times, even learned how to find-replace a color in the CSS file. Computer skills: improving.

Then I went to GT and doing anything about anything went out the window for a few years. I kinda hoped anybody looking
for a portfolio would go to my meager github profile instead of my aging wordpress site.

But I also forgot the middle there, when I was getting all jazzed up on a frontend project as an intern and I thought I would learn Ruby on Rails and hand code this whole thing. Turns out, web development... yeah. Not so much my thing. I'm a little more of an infrastructure and HPC gal.

When that interest petered out, I hopped on the static generator bandwagon. Now that I was a professional, I was going to
get this done using the tool I knew best: Scala. Except that all the half-ass Scala-based static site generators worked
fine for the dudes (all dudes) who wrote them, but heaven forbid you want to extend them or do something different. I think I got something working with one of them, it was definitely a battle. I started the slow, slow process of moving Wordpress posts over to it.

Never fear! I'll write my own Scala-based static site generator. Sometime. Next week? Next decade? But it turns out that it's a little
hard to get motivated to write code after a whole day of writing code.

So the cobbler's shoes continued to rot in the corner until something at work made me revisit this topic of SSGs.

And it turns out this project called Jekyll has gotten a ton of attention in the past few years with really excellent
documentation. And it turns out that it supports a lot of the features that I wanted out of an SSG.

It took not even two minutes to create a new Jekyll site, and it took minimal effort to port the few posts I had rescued from a wordpress install to Markdown for Jekyll.

It feels relieving and defeatist at the same time to make this move. The truth is that I'm not driven to learn real, actual web development at the moment. Software development is a little like "art" or "science" in that it's a catchall term for field that's almost infinitely vast at this point. There is nothing wrong with using battle-hardened tools written by hundreds of people who gave intense attention to all the details that, for my ill-fated scala-based project, were just lurking on a to-do list. So here I am, swallowing the (delightful!) pill for "Didn't build it here" syndrome.
