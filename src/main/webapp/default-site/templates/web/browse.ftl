

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<!--[if IE 9]><html xmlns="http://www.w3.org/1999/xhtml" class="ie9"><![endif]-->
<!--[if gt IE 9]><!--> <html xmlns="http://www.w3.org/1999/xhtml"> <!--<![endif]-->
<head>
   <title>Crafter Studio</title>

<!-- Shortcut Icons -->
   <link rel="shortcut icon" href="/share/favicon.ico" type="image/vnd.microsoft.icon" />
   <link rel="icon" href="/share/favicon.ico" type="image/vnd.microsoft.icon" />

<!-- Site-wide YUI Assets -->
   <link rel="stylesheet" type="text/css" href="/share/yui/reset-fonts-grids/reset-fonts-grids.css" />
   <link rel="stylesheet" type="text/css" href="/share/themes/cstudioTheme/yui/assets/skin.css" />
<!-- Common YUI components: RELEASE -->
   <script type="text/javascript" src="/share/yui/utilities/utilities.js"></script>
   <script type="text/javascript" src="/share/yui/button/button-min.js"></script>
   <script type="text/javascript" src="/share/yui/container/container-min.js"></script>
   <script type="text/javascript" src="/share/yui/menu/menu-min.js"></script>
   <script type="text/javascript" src="/share/yui/json/json-min.js"></script>
   <script type="text/javascript" src="/share/yui/selector/selector-min.js"></script> 
   <script type="text/javascript" src="/share/yui/connection/connection-min.js"></script>
   <script type="text/javascript" src="/share/yui/element/element-min.js"></script>
   <script type="text/javascript" src="/share/yui/dragdrop/dragdrop-min.js"></script>
   <script type="text/javascript" src="/share/yui/yahoo-dom-event/yahoo-dom-event.js"></script>
   <script type="text/javascript" src="/share/yui/animation/animation-min.js"></script>
   <script type="text/javascript" src="/share/yui/resize/resize-min.js"></script>
   <link rel="stylesheet" type="text/css" href="/share/yui//container/assets/skins/sam/container.css" />
   <link rel="stylesheet" type="text/css" href="/share/yui/assets/skins/sam/resize.css" />

<!-- Site-wide Common Assets -->
   <script type="text/javascript" src="/share/themes/cstudioTheme/js/global.js"></script>
   <link rel="stylesheet" type="text/css" href="/share/themes/cstudioTheme/base.css" />
   <link rel="stylesheet" type="text/css" href="/share/themes/cstudioTheme/dashboard.css" />
   <link rel="stylesheet" type="text/css" href="/share/themes/cstudioTheme/dashboard-presentation.css" />
   <link rel="stylesheet" type="text/css" href="/share/themes/cstudioTheme/presentation.css" />
   <link rel="stylesheet" type="text/css" href="/share/themes/cstudioTheme/css/global.css" />
   <script type="text/javascript" src="/share/js/bubbling.v1.5.0.js"></script>
   <script type="text/javascript" src="/share/js/flash/AC_OETags.js"></script>
   <script type="text/javascript" src="/share/service/messages.js?locale=en_US"></script>
   <script type="text/javascript" src="/share/js/alfresco.js"></script>
   <script type="text/javascript" src="/share/js/forms-runtime.js"></script>
   <script type="text/javascript">
    //<![CDATA[
      Alfresco.constants.DEBUG = false;
      Alfresco.constants.PROXY_URI = window.location.protocol + "//" + window.location.host + "/share/proxy/alfresco/";
      Alfresco.constants.PROXY_URI_RELATIVE = "/share/proxy/alfresco/";
      Alfresco.constants.PROXY_FEED_URI = window.location.protocol + "//" + window.location.host + "/share/proxy/alfresco-feed/";
      Alfresco.constants.THEME = "cstudioTheme";
      Alfresco.constants.URL_CONTEXT = "/share/";
      Alfresco.constants.URL_PAGECONTEXT = "/share/page/";
      Alfresco.constants.URL_SERVICECONTEXT = "/share/service/";
      Alfresco.constants.URL_FEEDSERVICECONTEXT = "/share/feedservice/";
      Alfresco.constants.USERNAME = "admin";
   //]]></script>
   <script type="text/javascript">//<![CDATA[
      Alfresco.constants.URI_TEMPLATES =
      {
         remote-site-page: "/site/{site}/{pageid}/p/{pagename}",
         remote-page: "/{pageid}/p/{pagename}",
         share-site-page: "/site/{site}/{pageid}/ws/{webscript}",
         sitedashboardpage: "/site/{site}/dashboard",
         contextpage: "/context/{pagecontext}/{pageid}",
         sitepage: "/site/{site}/{pageid}",
         userdashboardpage: "/user/{userid}/dashboard",
         userpage: "/user/{userid}/{pageid}",
         userprofilepage: "/user/{userid}/profile",
         userdefaultpage: "/user/{pageid}",
         consoletoolpage: "/console/{pageid}/{toolid}",
         consolepage: "/console/{pageid}",
         share-page: "/{pageid}/ws/{webscript}"
      }
   //]]></script>
   <script type="text/javascript">//<![CDATA[
      Alfresco.constants.HTML_EDITOR = 'tinyMCE';
   //]]></script>

<!-- Component Assets -->

<script type="text/javascript" src="/share/components/cstudio-common/common-api.js"></script>
<script type="text/javascript" src="/share/components/cstudio-browse/browse.js"></script>
<script type="text/javascript" src="/share/yui/calendar/calendar-min.js"></script> 

<link rel="stylesheet" type="text/css" href="/share/yui/assets/skins/sam/calendar.css" />
<link rel="stylesheet" type="text/css" href="/share/themes/cstudioTheme/css/global.css" />
<link rel="stylesheet" type="text/css" href="/share/themes/cstudioTheme/css/search.css" />
<link rel="stylesheet" type="text/css" href="/share/themes/cstudioTheme/css/forms-default.css" />

<!-- Template Assets -->
   <script type="text/javascript" src="/share/yui/treeview/treeview-min.js"></script> 
   <script type="text/javascript" src="/share/yui/animation/animation-min.js"></script>
   <script type="text/javascript" src="/share/themes/cstudioTheme/js/global.js"></script>
   <script type="text/javascript" src="/share/components/cstudio-form/swfobject.js"></script>
   <script type="text/javascript" src="/share/components/cstudio-browse/browse.js"></script>

  <!-- filter templates -->
   <script type="text/javascript" src="/share/components/cstudio-browse/filters/common.js"></script>
   <script type="text/javascript" src="/share/components/cstudio-browse/filters/default.js"></script>

  <!-- result templates -->
   <script type="text/javascript" src="/share/components/cstudio-search/results/default.js"></script>
       <script type="text/javascript" src="/share/components/cstudio-search/results/image.js"></script>   
       <script type="text/javascript" src="/share/components/cstudio-search/results/flash.js"></script>   
   
   <link href="/share/themes/cstudioTheme/css/icons.css" type="text/css" rel="stylesheet">
   <link href="/share/yui/container/assets/container.css" type="text/css" rel="stylesheet">

<!-- MSIE CSS fix overrides -->
   <!--[if lt IE 7]><link rel="stylesheet" type="text/css" href="/share/themes/cstudioTheme/ie6.css" /><![endif]-->
   <!--[if IE 7]><link rel="stylesheet" type="text/css" href="/share/themes/cstudioTheme/ie7.css" /><![endif]-->
</head>

<body class="yui-skin-cstudioTheme">
   <div class="sticky-wrapper">
<div id="global_x002e_cstudio-browse">
    <div id="global_x002e_cstudio-browse_x0023_default">

  <script>
    /**
     * contextual variables 
     * note: these are all fixed at the moment but will be dynamic
     */
    CStudioAuthoringContext = {
      user: "admin",
      role: "admin", 
      site: "rosie",
      baseUri: "/share",
      authoringAppBaseUri: "http://127.0.0.1:8080/share",
      formServerUri: "http://127.0.0.1:8080/form-server",
      previewAppBaseUri: "http://127.0.0.1:8080",
      liveAppBaseUri: "http://rosie",
      contextMenuOffsetPage: true,
      brandedLogoUri:"/proxy/alfresco/cstudio/services/content/content-at-path?path=/cstudio/config/app-logo.png",
      homeUri: "/page/site/rosie/dashboard",
      navContext: "default",
      cookieDomain: "${filter.cookieDomain}"
    };
    
  YEvent.onAvailable("cstudio-command-controls", function() {
    CStudioAuthoring.Utils.addCss('/service/cstudio/wcm/preview/overlay/css.css?baseUrl=' +
                       CStudioAuthoringContext.baseUri);
                       
    var formControls = new CStudioAuthoring.CommandToolbar("cstudio-command-controls", true);
    
    formControls.addControl("formSaveButton", "Add Item", function() { 

      var searchId = CStudioAuthoring.Utils.getQueryVariable(document.location.search, "searchId");
      var crossServerAccess = false;
      
        try {
          // unfortunately we cannot signal a form close across servers
          // our preview is in one server
          // our authoring is in another
          // in this case we just close the window, no way to pass back details which is ok in some cases
          if(window.opener.CStudioAuthoring) { }
        }
        catch(crossServerAccessErr) {
          crossServerAccess = true;
        }
  
      if(window.opener && !crossServerAccess) {
        
            if(window.opener.CStudioAuthoring) {
    
              var openerChildSearchMgr = window.opener.CStudioAuthoring.ChildSearchManager;
  
              if(openerChildSearchMgr) {
              
                var searchConfig = openerChildSearchMgr.searches[searchId];
                
                if(searchConfig) {
                  var callback = searchConfig.saveCallback;
  
                  if(callback) {
                    var selectedContentTOs = CStudioAuthoring.SelectedContent.getSelectedContent();
    
                openerChildSearchMgr.signalSearchClose(searchId, selectedContentTOs); 
                  }
                  else {
                //TODO PUT THIS BACK 
                    //alert("no success callback provided for seach: " + searchId);
                  }
                }
                else {
                  alert("unable to lookup child form callback for search:" + searchId);
                }
              }
              else {     
            alert("unable to lookup parent context for search:" + searchId);
              }             
            }
        
        window.close();
      }
      else {
        // no window opening context or cross server call
        // the only thing we can do is close the window
        window.close();
      }
    });
  
    formControls.addControl("formSaveButton", "Cancel", function() { 
      window.close();
    });
  }); 

  </script>

  <div id="cstudio-wcm-search-wrapper" style="min-width: 1130px;">

    <div id="cstudio-wcm-search-main">        
      <div id="cstudio-wcm-search-search-title" class="cstudio-wcm-searchResult-header"></div>
      <div id="cstudio-wcm-search-filter-controls" style="width:230px; min-height:570px; background-color:white; float:left; padding: 10px 20px; border-radius: 5px; float: left; border: 1px #ccc solid; margin-bottom: 10px;";"></div>
       
        <div id="cstudio-wcm-search-result" style="min-width: 715px; width:67%; border-radius: 5px; float: left; border: 1px #ccc solid; margin-bottom: 10px;  margin-left: 10px; overflow:hidden;">
         <div id="cstudio-wcm-search-result-in-progress" class="cstudio-wcm-search-result-in-progress-img"></div>
        &nbsp;  
      </div>
      <div style="clear:both"></div>

    </div>
  </div>  
    </div>

</div>  <div id="cstudio-command-controls"></div>
   </div>
</body>
</html>
