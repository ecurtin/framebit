# framebit.org

## Developing

This 10,000th iteration of this site is built using 
the [Pelican](http://docs.getpelican.com/en/stable/index.html) static site generator.

1. Clone the site.

2. Create the virtualenv, source, and install pelican 

```bash
pyenv virtualenv 3.7.3 pelican
pyenv local pelican
pip install pelican markdown sass
```

2. Compile the Sass to CSS

```bash
sass --watch theme/static/sass/collector.sass:theme/static/css/output.css
```

2. Do the site generation

```bash
pelican content
```

3. Run the server

```bash
cd ~/projects/yoursite/output
python -m pelican.server
```

4. Navigate to `localhost:8000`

It's best to run the server from a separate terminal as it will reload on changes, which is handy!

## Previous Frameworks

- iWeb (lol)
- Wordpress
- Drupal (that didn't stick)
- Different Wordpress
- I know, I'll write my own static site generator in Scala! (lol, no)
- Jekyll
- Pelican