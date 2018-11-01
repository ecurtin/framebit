#!/usr/bin/env python
# -*- coding: utf-8 -*- #
from __future__ import unicode_literals
from datetime import date

CURRENTYEAR = date.today().year

# Specify a customized theme, via path relative to the settings file
THEME = "theme"

# THEME_STATIC_DIR = 'theme/static'
THEME_STATIC_PATHS = ['static']
CSS_FILE = 'output.css'

AUTHOR = u'Emily Curtin'
SITENAME = u'Emily Curtin'
# SITEURL = 'http://framebit.org'
SITEURL = ''

ARTICLE_ORDER_BY = 'reversed-date'
PAGE_ORDER_BY = 'reversed-date'

PATH = 'content'

TIMEZONE = 'America/New_York'

DEFAULT_LANG = u'en'

# Feed generation is usually not desired when developing
FEED_ALL_ATOM = None
CATEGORY_FEED_ATOM = None
TRANSLATION_FEED_ATOM = None
AUTHOR_FEED_ATOM = None
AUTHOR_FEED_RSS = None

# Blogroll
LINKS = (('Pelican', 'http://getpelican.com/'),
         ('Python.org', 'http://python.org/'),
         ('Jinja2', 'http://jinja.pocoo.org/'),
         ('You can modify those links in your config file', '#'),)

# Social widget
SOCIAL = (('You can add links in your config file', '#'),
          ('Another social link', '#'),)

DEFAULT_PAGINATION = False

# Uncomment following line if you want document-relative URLs when developing
#RELATIVE_URLS = True

DISPLAY_PAGES_ON_MENU = False
DISPLAY_CATEGORIES_ON_MENU = False

MENUITEMS = (
    ('Home', '/'),
    ('About', '/pages/about.html'),
    ('Paintings', '/paintings.html'),
    ('Tech', '/tech.html'),
    ('Blog', '/blog.html')
)

DIRECT_TEMPLATES = ['index', 'categories', 'authors', 'archives', 'blog', 'paintings', 'tech']
# TEMPLATE_PAGES = {'/Users/ecurtin/git/framebit/theme/templates/blog.html': 'blog.html'}
