Template: article
Title:  "Hockney Style Photo Collages and Composites"
Date:   2014-04-20 22:16:13 -0400
Categories: art code
Thumbnail: https://farm6.staticflickr.com/5674/23510842914_bf9fe8aafb_o.png
Summary: 
    Creating a custom image manipulator in the style of David Hockney collages 
    using Java because I didn't know any better at the time.

I listened to a lot of Bowie during this project. It was roughly period appropriate.

Input: The classic Aladdin Sane cover:

[![DavidBowie](https://farm6.staticflickr.com/5639/23843394850_687950a302_o.jpg)](https://www.flickr.com/photos/emilymaycurtin/23843394850/in/datetaken/ "DavidBowie")

Hockney-Style Composite Output:

[![BowieComposite](https://farm6.staticflickr.com/5674/23510842914_bf9fe8aafb_o.png)](https://www.flickr.com/photos/emilymaycurtin/23510842914/in/datetaken/ "BowieComposite")

David Hockney is an artist who has dabbled in lots of different media and disciplines, from painting to stage design to, briefly and famously, photography.

Though [Wikipedia says](http://en.wikipedia.org/wiki/David_Hockney#The_.22joiners.22) he eventually grew frustrated with the camera's single-eye approach to a scene, his efforts to compensate for it through collages and polaroid composites are well documented.

While Hockney's compositions are created from many different images with all the quirks and subtleties of a human hand holding a 35mm or polaroid camera, my idea was to recreate the style of his collages and composites using a single source image.

[Hockney's collages](http://www.hockneypictures.com/photos/photos_collages.php) are composed of lots of photos of the same subject or same scene, layered and mixed and jumbled to give textural comment. [The polaroid composites](http://www.hockneypictures.com/photos/photos_polaroids.php) are orderly layouts of polaroids taken of the same scene at different times and slightly different points.

[![CrocusComposite_Large](https://farm6.staticflickr.com/5714/24139063255_d07179d9e0_c.jpg)](https://www.flickr.com/photos/emilymaycurtin/24139063255/in/datetaken/ "CrocusComposite_Large")

To approach this, I built a custom library centered around the abstraction of ImageTiles. These are sub-images of the source file that have lots of different properties: show, don't show, zoom in, zoom out, bright, darken, emphasize, scatter, and room for lots more.

After a semester spent mired mostly in C++ with a little Python, I took the liberty of doing this in Java, which was... really nice, actually. It was fun to be able to get ideas out without tripping over syntax. I will get around to learning Python properly someday, but that is not this day! The source code is here: [https://github.com/ecurtin/PhotoCollage/](https://github.com/ecurtin/PhotoCollage/)

Using this custom library, which relied on some oldie but goodie and MUCH MORE NICELY FORMATTED code from my dear old writes-Java-like-its-70's-Fortran computer graphics professor, I built an application to make collages and an application to make composites.

[![BowieCollage](https://farm6.staticflickr.com/5639/24139061985_a50b10419c_o.png)](https://www.flickr.com/photos/emilymaycurtin/24139061985/in/datetaken/ "BowieCollage")

The applications follow roughly the same format:

*   Input the image
*   Split it into ImageTiles
*   Pipe these imageTiles through a number of transformations including
    *   Scatter: move the coordinates for where the tile will be rendered to a random location a random distance away
    *   Show/Hide: For the collage, randomly show or hide the tile based on a density parameter
    *   Brighten/Darken: make the image randomly a little brighter or a little darker (I found a little goes a looong way for this one)
    *   Zoom: randomly zoom the tile in or out.
    *   Others! It's super easy to write a method to do something to a single tile and simply add it in the main run loop of the program.

[![strawberryComposite](https://farm2.staticflickr.com/1668/24030956762_e9f461e63a_b.jpg)](https://www.flickr.com/photos/emilymaycurtin/24030956762/in/datetaken/ "strawberryComposite")

Bonus, although I haven't gotten around to it, this is embarrassingly parallel. I could speed this up IMMENSELY by generating a bunch of worker threads to each work on their own tile or small set of tiles.

And speaking of things I haven't gotten around to yet, there's lot of room for improvement here, especially in the collage. A few ideas:

To increase the analog or human jitter realism:

*   Different kinds of exposure modification beyond just lighten/darken
*   Random rotation within a specified range
*   Color distortion to simulate differences apparent in the chemical development process

To further the aesthetic qualities:

*   Apply scatter based on heuristics instead of pure probability. Move in the direction of the gradient of the tile?
*   Apply heuristics and/or computer vision techniques to detect interesting features and large swaths of similar space, emphasizing and de-emphasizing as appropriate (is de-emphasizing a word?)

To make the application more friendly/usable, since apparently nobody likes one-liner shell scripts with ~18 anonymous numerical parameters

*   An actual GUI! Something I haven't had to think about since I started doing Systems! Maybe github.io? Maybe just a .jar?
*   Paralleliize (how on earth do you spell that?) for speed
*   Perhaps an interface where the user can graphically select regions of interest as input

Finally, Professor Irfan Essa:

[![EssaComposite](https://farm2.staticflickr.com/1670/24139068935_5fb6a0cf11_o.png)](https://www.flickr.com/photos/emilymaycurtin/24139068935/in/datetaken/ "EssaComposite")
