import au.com.langdale.soapbox.Publisher._
import au.com.langdale.soapbox.{Disqus, Twitter}
import sbt._


object Templates extends Plugin {
  override def projectSettings = Seq(

    siteDefaultTemplate := {
      (title, content) => {
        <html>
          <head>
            <title>{title}</title>
            <link rel="stylesheet" href="css/custom.css" type="text/css" />
            <link rel="stylesheet" href="css/bootstrap.min.css" type="text/css" />
            <link rel="stylesheet" href="styles/default.css" type="text/css" />
            <link rel="icon" href="favicon.ico" type="image/x-icon" />
            <link rel="shortcut icon" href="favicon.ico" type="image/x-icon" />
          </head>
          <body>
            <div>
              <div id="banner">
                <div id="illust"/>
                <div id="logo"/>
              </div>
              <div id="menu">
                <ul class="nav nav-pills">
                  {
                  for((text, target) <- siteMenu.value.entries) yield {
                    <li><a href={target} class="menu">{text}</a></li>
                  }
                  }
                </ul>
              </div>
              <div id="main">
                <div class="container">
                  <div id="content">{ content }</div>
                </div>
              </div>

              <div id="footer">{ siteFooter.value }</div>
            </div>
            <script src="js/bootstrap.min.js"></script>
          </body>
        </html>
      }
    }
  )
}