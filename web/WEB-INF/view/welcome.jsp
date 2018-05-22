
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
                <form method="POST" class="navbar-form navbar-left" action="./searchTopics" accept-charset="UTF-8" role="form" id="custom-search-form">
                    <input type="search" name="searchtext" class="form-control pull-left" style="width:85%" id="search" placeholder="Search..." />
                <div class="input-group-btn">
                    <span class="pull-left"><input class="btn btn-default" type="submit"><i class="glyphicon glyphicon-search"></i></span>
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
<c:if test="${searcherror1 != null}">
    <div class="bg-danger" style="padding: 15px; border-radius: 4px; color:black; max-width: 500px; margin: 0px auto;">
    ${searcherror1}</div>
</c:if>
<c:choose>
<c:when test = "${foundTopics!=null}">
    <div class="container-fluid">
        <div class="masonry">
            <c:forEach var="topic" items="${foundTopics}" varStatus="iter">
            <c:forEach var="p" items="${topic.pinsCollection}" varStatus="iter">
                <div class="item">
                <img src="${pageContext.request.contextPath}/images?pinName=${p.pinsPK.name}" class="img-rounded img-responsive" height="250px" style="width:100%">
                <c:if test="${p.description!=null}"><div class="text-box"><c:out value="${p.description}"/></div></c:if>
                </div>
            </c:forEach>
            </c:forEach>
        </div>
    </div>
</c:when>
<c:otherwise>                        
<div class="container-fluid">                       
<div class="masonry">
    <c:forEach var="p" items="${selPins}" varStatus="iter">
    <div class="item">
        <img src="${pageContext.request.contextPath}/images?pinName=${p.pinsPK.name}" class="img-rounded img-responsive" height="250px" style="width:100%">
        <c:if test="${p.description!=null}"><div class="text-box"><c:out value="${p.description}"/></div></c:if>
    </div>
    </c:forEach>
       
</div></div>
</c:otherwise>
</c:choose>
</div></div>
   

 <script
    async defer
    data-pin-hover="true" data-pin-tall="true"
    data-pin-url="https://www.pinterest.com/pin/"
    src="//assets.pinterest.com/js/pinit.js"
></script>   
<%@ include file='footer.jspf' %>