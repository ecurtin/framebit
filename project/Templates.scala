import au.com.langdale.soapbox.Publisher._
import au.com.langdale.soapbox.{GoogleAnalytics, Disqus, Twitter}
import sbt._


object Templates extends Plugin {
  override def projectSettings = Seq(

    siteDefaultTemplate := {
      (title, content) => {
        <html xmlns="http://www.w3.org/TR/html4/">
          <head>
            <title>{title}</title>
            <link rel="stylesheet" href="styles/default.css" type="text/css" />
          </head>
          <body>
            <div>
              <div id="banner">
                <div id="illust"/>
                <div id="logo"/>
              </div>
              <div id="main">
                <div class="container">
                  <div id="content">{ content }</div>
                </div>
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
              <div id="footer">{ siteFooter.value }</div>
            </div>
          </body>
        </html>
      }
    }




//    siteTemplates += Template("*.md",
//      (title, content) => {
//        <html xmlns="http://www.w3.org/TR/html4/">
//          <head><title>{title}</title></head>
//          <body>{content}</body>
//        </html>
//      }
//    )
  )
}