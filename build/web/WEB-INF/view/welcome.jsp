
<%@ include file='header.jspf' %>
<script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

 <script>
    window.pAsyncInit = function() {
        PDK.init({
            appId: "4955316829072410035", 
            cookie: true
        });
    };

    (function(d, s, id){
        var js, pjs = d.getElementsByTagName(s)[0];
        if (d.getElementById(id)) {return;}
        js = d.createElement(s); js.id = id;
        js.src = "//assets.pinterest.com/sdk/sdk.js";
        pjs.parentNode.insertBefore(js, pjs);
    }(document, 'script', 'pinterest-jssdk'));
</script>
<div class="top-content">
    <div class="inner-bg">   	
        <div class="container-fluid">
            
            <div class="row">
                <div class="col-sm-8 col-sm-offset-2 text"><h2><strong>DIY Wedding Planner</h2>
                    <h2>Trending Topics</h2></div>
            </div>

            <div class="row">
            <div class="col-sm-6 col-md-6"> 
                <br>
                <p></p>
                <form class="navbar-form navbar-left" action="./searchtrends">
                <!-- TODO: activate search function-->
                <div class="input-group-btn">
                    <input type="search" class="form-control pull-left" style="width:85%" id="search" placeholder="Search..." />
                   
                        <span class="pull-left"><a class="btn btn-default" type="submit"><i class="glyphicon glyphicon-search"></i></a></span>
                    
                </div>
                </form>
                    
            </div>
            <div class="col-sm-6 col-md-6">
                    <ul class="nav navbar-nav navbar-right">
                        <h3><c:out value="${sessionScope.user}"/></h3>
                        <li class="dropdown">
                            <a class="dropdown-toggle" data-toggle="dropdown"><i class="fa fa-bell fa-fw" style="color:white"></i> Notifications <i class="fa fa-caret-down"></i></a>
                            <ul class="dropdown-menu dropdown-alerts" style="width:310px;padding: 10px 10px 10px 10px;">
                       <c:forEach var="f" items="${followers}" varStatus="iter">
                        <li>
                            <div style="padding: 3px 0px 3px 0px;">
                                <span class="fa fa-chain fa-fw" style="color:gray;"></span>
                                <span style="color:gray;"><c:out value="${f.follower}"/></span>
                                <span style="color:gray;">requests to follow you </span>
                                <p>
                                    <a href="${pageContext.request.contextPath}/allowFollowUser?follower=${f.follower}" class="btn btn-xs btn-default"><span class="glyphicon glyphicon-ok-circle"> Allow </span></a>
                                    <a href="${pageContext.request.contextPath}/blockFollowUser?follower=${f.follower}" class="btn btn-xs btn-default"><span class="glyphicon glyphicon-ban-circle"> Block</span></a>
                                    <span class="pull-right text-muted small">12 minutes ago</span></p>
                            </div>
                        </li>
                        <li class="divider"></li>
                        </c:forEach>
                         <c:forEach var="b" items="${pinboards}" varStatus="iter">
                        <li>
                            <div style="padding: 3px 0px 3px 0px;">
                                <span class="fa fa-chain fa-fw" style="color:gray;"></span>
                                <span style="color:gray;"><c:out value="${b.follower}"/></span>
                                <span style="color:gray;">requests to follow your board <c:out value="${b.pinboardsName}"/></span>
                                <p>
                                    <a href="${pageContext.request.contextPath}/allowFollowBoard?follower=<c:out value="${b.follower}"/>&pinboard=<c:out value="${b.pinboardsName}"/>" class="btn btn-xs btn-default"><span class="glyphicon glyphicon-ok-circle"> Allow </span></a>
                                    <a href="${pageContext.request.contextPath}/blockFollowBoard?follower=<c:out value="${b.follower}"/>&pinboard=<c:out value="${b.pinboardsName}"/>" class="btn btn-xs btn-default"><span class="glyphicon glyphicon-ban-circle"> Block</span></a>
                                    
                            </div>
                        </li>
                        <li class="divider"></li>
                        </c:forEach>
                       
                        </ul>
                        </li>
                        <li><a href="${pageContext.request.contextPath}/viewProfile"><i class="fa fa-user fa-fw"></i> User Profile </a></li>
                        
                        <li><a href="${pageContext.request.contextPath}/editUser"><i class="fa fa-gear fa-fw"></i> Settings </a></li>
                        <li><a href="${pageContext.request.contextPath}/Logout"><i class="fa fa-sign-out fa-fw"></i> Log out </a></li>

                    </ul>
                        
            </div></div>
                        
<div class="container-fluid">                       
<div class="masonry">
        <div class="item">
                <img src="img/WeddingImg5.jpg"></a></div>
        <div class="item">
            <div class="text-box">The ring that binds.. </div>
        </div>
        <div class="item">
                <img src="http://media-cache-ec0.pinimg.com/736x/c3/10/22/c3102281f88237e7a2515099d2e6651f.jpg">
        </div>
        <div class="item">
                <img src="http://media-cache-ec0.pinimg.com/736x/0f/d0/84/0fd0847f7b48e5f16d896f62baa31b97.jpg">
        </div>
        <div class="item">
            <iframe width="425" height="350" frameborder="0" scrolling="no" marginheight="0" marginwidth="0" src="https://maps.google.com/maps?f=q&amp;source=s_q&amp;hl=en&amp;geocode=+&amp;q=taj+mahal&amp;ie=UTF8&amp;hq=&amp;hnear=&amp;ll=27.175015,78.042155&amp;spn=0.006295,0.006295&amp;t=m&amp;output=embed"></iframe>
        </div>
        <div class="item">
            <div class="text-box"><a href="https://twitter.com/w3bits_">I tweet sometimes.</a></div>
        </div>
        <div class="item">
                <img src="http://media-cache-ak0.pinimg.com/736x/2e/7f/db/2e7fdb7ed765973407fed0b0141bb126.jpg">
            <div class="text-box">
                <h2>Thirst Quenchers</h2></div>
        </div>
        <div class="item">
            <img src="img/WeddingImg4.png">
            <div class="text-box">Lorem ipsum dolor sit amet, dicta dolore adipisci hic ipsam velit deleniti possimus cumque accusantium rerum quibusdam.</div>
        </div>
        <div class="item">
            <img src="img/WeddingImg3.png">
            <div class="text-box">Text-only masonry block.</div>
        </div>
        <div class="item">
            <iframe width="640" height="390" src="http://www.youtube.com/embed/cwGq-uy0bhI" frameborder="0" allowfullscreen=""></iframe>
        </div>
        <div class="item">
            <div class="text-box"><a href="https://plus.google.com/+w3Bits">Circle me on Google+</a></div>
        </div>
        <div class="item">
            <iframe src="http://player.vimeo.com/video/91605331" width="500" height="281" frameborder="0" webkitallowfullscreen="" mozallowfullscreen="" allowfullscreen=""></iframe>
        </div>
        <div class="item">
            <img src="img/WeddingImg2.png">
            <div class="text-box">Text-only masonry block.</div>
        </div>
        <div class="item">
            <img src="img/WeddingImg1.png">
            <div class="text-box">Text-only masonry block.</div>
        </div>

    </div></div>
   

 <script
    async defer
    data-pin-hover="true" data-pin-tall="true"
    data-pin-url="https://www.pinterest.com/pin/"
    src="//assets.pinterest.com/js/pinit.js"
></script>   
<%@ include file='footer.jspf' %>