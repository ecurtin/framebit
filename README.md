# framebit.org

## Developing

This 10,000th iteration of this site is built using 
the [Pelican](http://docs.getpelican.com/en/stable/index.html) static site generator.

1. Clone the site.

2. Create the virtualenv with ```virtualenv --python=`which python3` ./venv```

3. ```source ./venv/bin/activate```

2. `pip install pelican markdown` 

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