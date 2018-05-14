<%-- 
    Document   : userProfile
    Created on : Apr 3, 2018, 11:41:13 PM
    Author     : louisacheong
--%>

<%-- 
    Document   : userProfile
    Created on : Apr 3, 2018, 11:41:13 PM
    Author     : louisacheong
--%>

<%@ include file='header.jspf' %>
<link rel="stylesheet" href="css/admin.css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>



<div class="top-content">
    <div class="inner-bg">   	
        <div class="container-fluid">
           
                       
                

        <!-- Navigation -->
        <nav class="navbar navbar-default navbar-static-top" role="navigation" style="margin-bottom: 0">
            <div class="navbar-header"><div class="col-sm-12"><h2><strong>Pin Now 4 Wedding</h2>
                    <h2>User Profile</h2></div></div>
            <div class="navbar-top-links">
                
            
                <div class="col-sm-12">
                   <div class="row"> 
                   <ul class="nav navbar-nav navbar-right">
                        <h3><c:out value="${sessionScope.user}"/></h3>
                         <p>
                            <a data-pin-do="buttonFollow" href="https://www.pinterest.com/pinterest/"><c:out value="${sessionScope.followerCount}"/> Followers</a>
                            <a data-pin-do="buttonFollow" href="https://www.pinterest.com/pinterest/"><c:out value="${sessionScope.followedCount}"/> Followed</a>
                        </p>
                        <li class="dropdown">
                            <a class="dropdown-toggle" data-toggle="dropdown"><i class="fa fa-bell fa-fw" style="color:gray"></i> Notifications <i class="fa fa-caret-down"></i></a>
                            <ul class="dropdown-menu dropdown-alerts" style="width:310px;padding: 10px 10px 10px 10px;">
                       <c:forEach var="f" items="${followers}" varStatus="iter">
                        <li>
                            <div style="padding: 3px 0px 3px 0px;">
                                <span class="fa fa-chain fa-fw" style="color:gray;"></span>
                                <span style="color:gray;"><c:out value="${f.follower}"/></span>
                                <span style="color:gray;">requests to follow you </span>
                                <p>
                                    <a href="${pageContext.request.contextPath}/allowFollowUser?follower=<c:out value="${f.follower}"/>" class="btn btn-xs btn-default"><span class="glyphicon glyphicon-ok-circle"> Allow </span></a>
                                    <a href="${pageContext.request.contextPath}/blockFollowUser?follower=<c:out value="${f.follower}"/>" class="btn btn-xs btn-default"><span class="glyphicon glyphicon-ban-circle"> Block</span></a>
                                    
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
                                   
                <li><a href="${pageContext.request.contextPath}/viewProfile"><i class="fa fa-user fa-fw" style="color:gray"></i> User Profile</a></li>
                <li><a href="${pageContext.request.contextPath}/editUser"><i class="fa fa-gear fa-fw" style="color:gray"></i> Settings</a></li>
                <li><a href="${pageContext.request.contextPath}/Logout"><i class="fa fa-sign-out fa-fw" style="color:gray"></i> Logout</a></li>
                    
                
                    </ul>
             
                
                </div></div>
                    <div class="col-sm-12">
                        <div class="row"> 
                        <div class="jumbotron">
                            <div class="row">
                                <div class="col-sm-6 col-md-6">    
                                <div class="input-group custom-search-form">
                                <form method="POST" action="./searchUserandBoard" accept-charset="UTF-8" role="form" id="custom-search-form" class="custom-search-form">
                                <input type="text" name="searchtext" class="form-control" placeholder="Search for User/Board...">
                                <span class="input-group-btn">
                                <input class="btn btn-default" type="submit" value="Search">
                                    <i class="fa fa-search"></i>
                                
                                </span>
                                </form>
                                </div></div>
                                <div class="col-sm-6 col-md-6">
                                <c:if test= "${foundUser != null}">
                                <table id="userTable" >
                                <c:forEach var="foundUser" items="${foundUser}" varStatus="iter">
                                    <tr class="${((iter.index % 2) == 0) ? 'lightBlue' : 'white'}">
                                        <td>
                                            <img src="${initParam.userImagePath}${foundUser.username}.jpg"
                                                 alt="${foundUser.username}" class="img-rounded img-responsive" height="500px" width="386px"/>
                                            <h3><c:out value="${foundUser.email}"></c:out></h3>
                                                <h3><c:out value="${foundUser.username}"></c:out></h3>
                                                     <h4><c:out value="${foundUser.country}"></c:out></h4>
                                                
                                            <p>
                                            <a href="${pageContext.request.contextPath}/followUser?following=<c:out value="${foundUser.email}"/>" class="btn btn-xs btn-default"><i class="fa fa-chain fa-fw"></i> Follow</a>
                                            <a href="${pageContext.request.contextPath}/unfollowUser?following=<c:out value="${foundUser.email}"/>" class="btn btn-xs btn-default"><i class="fa fa-chain-broken fa-fw"></i> Unfollow</a>
                                            </p>
                                        </td>         
                                    </tr>
                                </c:forEach>
                                </table>
                                </c:if></div></div>
                                <div class="row">
                                    <div class="col-sm-6 col-md-6"></div> 
                                <div class="col-sm-6 col-md-6">
                                <c:if test="${foundBoards != null}">
                            <div><h3>Results : </h3></div>
                            <table id="boardTable" width="100%" class="table-hover table-striped">
                            <c:forEach var="p" items="${foundBoards}" varStatus="iter">
                                <tr class="${((iter.index % 2) == 0) ? 'lightBlue' : 'white'}">
                                <td>
                                    <h3><c:out value="${p.pinboardsPK.name}"></c:out></h3>
                                </td>
                                <td style="text-align: center;">
                                    <a href="${pageContext.request.contextPath}/followBoard?following=<c:out value="${p.pinboardsPK.userEmail}"/>&board=<c:out value="${p.pinboardsPK.name}"/>" class="btn btn-xs btn-default"><span class="glyphicon glyphicon-heart"></span> Follow</a>
                                </td>
                                <td style="text-align: center;">
                                    <a href="${pageContext.request.contextPath}/unfollowBoard?following=<c:out value="${p.pinboardsPK.userEmail}"/>&board=<c:out value="${p.pinboardsPK.name}"/>" class="btn btn-xs btn-default"><span class="glyphicon glyphicon-ban-circle"></span> Unfollow</a>
                                </td>
                                </tr>
                            </c:forEach>
                            </table>
                            </c:if>
                                <c:if test="${searcherror != null}">
                                    <div class="bg-danger" style="padding: 15px; border-radius: 4px; color:black; max-width: 500px; margin: 0px auto;">
                                    ${searcherror}</div>
                                </c:if>
                                <c:if test="${searcherror1 != null}">
                                    <div class="bg-danger" style="padding: 15px; border-radius: 4px; color:black; max-width: 500px; margin: 0px auto;">
                                    ${searcherror1}</div>
                                </c:if>
                                <c:if test="${followstatus != null}">
                                    <div class="bg-danger" style="padding: 15px; border-radius: 4px; color:black; max-width: 500px; margin: 0px auto;">
                                    ${followstatus}</div>
                                </c:if>
                                </div>
                                
                                </div>
                        </div> 
                        </div>
                    </div>
                    <div class="col-sm-12">
                        <c:if test="${boardstatus != null}">
                            <div class="bg-danger" style="padding: 15px; border-radius: 4px; color:black; max-width: 100%; margin: 0px auto;">
                                ${boardstatus}</div>
                        </c:if>
                            
                    </div>
                    <div class="col-sm-12">
                        <ul class="nav nav-pills">
                            <li class="active">
                                <a data-toggle="pill" href="#topics">Topics</a>
                            </li>
                            <li class>
                                <a data-toggle="pill" href="#boards" >Boards</a>
                                
                            </li>
                            <li class>
                                <a data-toggle="pill" href="#myuploads">My Uploads</a>
                            </li>
                        </ul>
                        <div class="tab-content">
                            <div class="tab-pane fade in active" id="topics">
                                <h4>Topics Pane</h4>
                                 <div class="row">
                                <c:if test = "${selectedTopic1!=null}">
                                <div class="col-lg-4 col-md-6">
                                <div class ="panel panel-default">
                                    <div class ="panel-heading"><i class="fa fa-hashtag"></i><c:out value="${selectedTopic1}"/></div>
                                    <div class="panel-body">
                                        <div class="container-fluid">
                                            <div class="masonry">
                                                <div class="item">
                                                    <img src="img/WeddingImg9.jpg">
                                                </div>
                                                <div class="item">
                                                    <img src="img/WeddingImg8.jpg"></div>
                                                <div class="item">
                                                    <img src="img/WeddingImg7.jpg"></div>
                                                <div class="item">
                                                    <img src="img/WeddingImg6.jpg"></div>
                                                <div class="item">
                                                    <img src="img/WeddingImg5.jpg"></div>
                                                <div class="item">
                                                    <img src="img/WeddingImg3.png"></div>
                                                <div class="item">
                                                    <img src="img/WeddingImg2.png"></div>
                                                <div class="item">
                                                    <img src="img/WeddingImg1.png"></div>
                                                <div class="item">
                                                    <img src="img/WeddingImg4.png"></div>
                                                </div>
                                                </div>
                                    </div></div></div></c:if>
                                    <c:if test = "${selectedTopic2!=null}">
                                    <div class="col-lg-4 col-md-6">
                                        <div class ="panel panel-default">
                                    <div class ="panel-heading"><i class="fa fa-hashtag"></i><c:out value="${selectedTopic2}"/></div>
                                    <div class="panel-body">
                                
                                    </div>
                                        </div></div></c:if>
                                    <c:if test = "${selectedTopic3!=null}"> 
                                    <div class="col-lg-4 col-md-6">
                                    <div class ="panel panel-default">
                                    <div class ="panel-heading"><i class="fa fa-hashtag"></i><c:out value="${selectedTopic3}"/></div>
                                    <div class="panel-body">
                                        <div class="container-fluid">
                                            <div class="masonry">
                                                <div class="item">
                                                    <img src="img/WeddingImg9.jpg"></div>
                                                <div class="item">
                                                    <img src="img/WeddingImg8.jpg"></div>
                                                <div class="item">
                                                    <img src="img/WeddingImg7.jpg"></div>
                                                <div class="item">
                                                    <img src="img/WeddingImg6.jpg"></div>
                                            </div>
                                        </div></div></div>
                                    </div></c:if>
                                 </div>
                                <!--next row-->
                                <div class="row">
                                    <c:if test = "${selectedTopic4!=null}">
                                        <div class="col-lg-4 col-md-6">
                                <div class ="panel panel-default">
                                    <div class ="panel-heading"><i class="fa fa-hashtag"></i><c:out value="${selectedTopic4}"/></div>
                                    <div class="panel-body">
                                        <div class="container-fluid">
                                            <div class="masonry">
                                                <div class="item">
                                                    <img src="img/WeddingImg9.jpg">
                                                </div>
                                                <div class="item">
                                                    <img src="img/WeddingImg8.jpg"></div>
                                                <div class="item">
                                                    <img src="img/WeddingImg7.jpg"></div>
                                                <div class="item">
                                                    <img src="img/WeddingImg6.jpg"></div>
                                                <div class="item">
                                                    <img src="img/WeddingImg5.jpg"></div>
                                                <div class="item">
                                                    <img src="img/WeddingImg3.png"></div>
                                                <div class="item">
                                                    <img src="img/WeddingImg2.png"></div>
                                                <div class="item">
                                                    <img src="img/WeddingImg1.png"></div>
                                                <div class="item">
                                                    <img src="img/WeddingImg4.png"></div>
                                                </div>
                                                </div>
                                    </div></div></div>
                                    </c:if>
                                    <c:if test = "${selectedTopic5 !=null}">
                                        <div class="col-lg-4 col-md-6">
                                <div class ="panel panel-default">
                                    <div class ="panel-heading"><i class="fa fa-hashtag"></i><c:out value="${selectedTopic5}"/></div>
                                    <div class="panel-body">
                                        <div class="container-fluid">
                                            <div class="masonry">
                                                <div class="item">
                                                    <img src="img/WeddingImg9.jpg">
                                                </div>
                                                <div class="item">
                                                    <img src="img/WeddingImg8.jpg"></div>
                                                <div class="item">
                                                    <img src="img/WeddingImg7.jpg"></div>
                                                <div class="item">
                                                    <img src="img/WeddingImg6.jpg"></div>
                                                <div class="item">
                                                    <img src="img/WeddingImg5.jpg"></div>
                                                <div class="item">
                                                    <img src="img/WeddingImg3.png"></div>
                                                <div class="item">
                                                    <img src="img/WeddingImg2.png"></div>
                                                <div class="item">
                                                    <img src="img/WeddingImg1.png"></div>
                                                <div class="item">
                                                    <img src="img/WeddingImg4.png"></div>
                                                </div>
                                                </div>
                                    </div></div></div>
                                    </c:if>
                                </div>
                                
                            </div>
                               
                            
                            <div class="tab-pane fade" id="boards">
                                <h4>Boards Pane</h4>
                                <div class="row">
                                <c:forEach var="board" items="${boards}" varStatus="iter">
                                    <c:if test="${board.isPrivate == false}">
                                <div class="col-lg-4 col-md-6">
                                <div class ="panel panel-default">
                                        <div class ="panel-heading"><i class="fa fa-file"></i><c:out value="${board.pinboardsPK.name}"></c:out></div>
                                    <div class="panel-body">
                                        <div class="container-fluid">
                                            <div class="masonry">
                                                <c:forEach var="p" items="${board.pinsCollection}" varStatus="iter">
                                                <div class="item">
                                                    <img src="${pageContext.request.contextPath}/images?pinName=${p.pinsPK.name}" style="width:100%">
                                                </div></c:forEach></div>
                                                <p>
                                                    <a href="${pageContext.request.contextPath}/editBoard?boardName=${board.pinboardsPK.name}" class="btn btn-xs btn-default"><span class="glyphicon glyphicon-edit"></span> Edit</a>
                                                    <a href="${pageContext.request.contextPath}/removeBoard?boardName=${board.pinboardsPK.name}" class="btn btn-xs btn-default"><span class="glyphicon glyphicon-trash"></span> Remove</a>
                                                </p>
                                                </div>
                                        </div></div></div></c:if></c:forEach>
                                    <div class="col-lg-4 col-md-6">
                                        <div class ="panel panel-default">
                                    <div class ="panel-heading"><i class="fa fa-file"></i>Embedded Boards from Pinterest</div>
                                    <div class="panel-body">
                                <p><a data-pin-do="embedBoard" data-pin-board-width="280" data-pin-scale-height="100" data-pin-scale-width="60" href="https://www.pinterest.com/l_cheong0283/dream-wedding/"></a></p>
                                <p><a data-pin-do="embedBoard" data-pin-board-width="280" data-pin-scale-height="100" data-pin-scale-width="60" href="https://www.pinterest.com/l_cheong0283/wedding-food-drinks"></a></p>  
                                <p><a data-pin-do="embedBoard" data-pin-board-width="280" data-pin-scale-height="100" data-pin-scale-width="60" href="https://www.pinterest.com/l_cheong0283/wedding-dresses/"></a></p>
                                <p>
                                    <a href="${pageContext.request.contextPath}/editBoard" class="btn btn-xs btn-default"><span class="glyphicon glyphicon-edit"></span> Edit</a>
                                    <a href="${pageContext.request.contextPath}/removeBoard" class="btn btn-xs btn-default"><span class="glyphicon glyphicon-trash"></span> Remove</a>
                                </p>
                                    </div>
                                        </div></div>
                                </div>
                                        
                                
                                <!-- /.row -->
                                <div class="row">
                                <h4>MY SECRET BOARDS</h4>
                                <div class="col-lg-4 col-md-6">
                                <div class ="panel panel-default">
                                    <div class ="panel-heading"><i class="fa fa-file"></i>For Him Gift Ideas</div>
                                    <div class="panel-body">
                                        <div class="container-fluid">
                                            <div class="masonry">
                                                <div class="item">
                                                    <img src="img/WeddingImg9.jpg"></div>
                                                </div>
                                                </div>
                                        </div></div></div>

                            <c:forEach var="board" items="${boards}" varStatus="iter">
                                <c:if test="${board.isPrivate == true}">
                            <div class="col-lg-4 col-md-6">
                            <div class ="panel panel-default">
                                    <div class ="panel-heading"><i class="fa fa-file"></i><c:out value="${board.pinboardsPK.name}"/></div>
                                    <div class="panel-body">
                                        <div class="container-fluid">
                                            <div class="masonry">
                                                <c:forEach var="p" items="${board.pinsCollection}" varStatus="iter">
                                                <div class="item">
                                                    <img src="${pageContext.request.contextPath}/images?pinName=${p.pinsPK.name}" style="width:100%"></div>
                                                </c:forEach>
                                               
                                            </div>
                                            <p>
                                                <a href="${pageContext.request.contextPath}/editBoard?boardName=${board.pinboardsPK.name}" class="btn btn-xs btn-default"><span class="glyphicon glyphicon-edit"></span> Edit</a>
                                                <a href="${pageContext.request.contextPath}/removeBoard?boardName=${board.pinboardsPK.name}" class="btn btn-xs btn-default"><span class="glyphicon glyphicon-trash"></span> Remove</a>
                                            </p>
                                        </div>
                                    </div></div></div></c:if></c:forEach>            
                            
                            <div class="col-lg-4 col-md-6">
                              
                            </div></div></div>
                            
                            
                            <div class="tab-pane fade" id="myuploads">
                            <div class="row">
                                <h4>Uploads Pane</h4>
                                <div class="col-lg-6 col-md-9">
                                <div class="panel panel-default">
                                    <div class="panel-heading">
                                        <h3 class="panel-title"><i class="fa fa-upload"></i>Upload Content Panel</h3>
                                    </div>
                                    <div class="panel-body">
                                    <form action="./uploadContent" method="post" enctype="multipart/form-data">    
                                    <div class="form-group">
                                        <label for="topic">Please select topic for Pin Image : </label>
                                    
                                        <select class="form-control" name="topic" style="border-radius: 0 0 4px 4px">
                                        <c:forEach var="topic" items="${topic}" varStatus="iter">
                                            <option value="<c:out value="${topic.name}"/>" > <c:out value="${topic.name}"/></option>
                                        </c:forEach>
                                        </select>
                                        <br>
                                        <label for="imageFile">Pin Image to be Uploaded (.jpg or .png) : </label>
                                        <input class="form-control" type="file" id="imageFile" name="imageFile" accept=".jpg, .png">
                                    
                                        <p class="help-block">Pin image will be added into the topic selected.</p>
                                        <br>
                                        <label for="description">Description (Optional) : </label>
                                            <input class="form-control" type="text" id="form-description" name="description">

                                        <label for="location">Location where pin is taken (Optional) : </label>
                                            <input class="form-control" name="location" type="text" id="form-address">

                                    </div>
                                    <div>
                                        <input type="submit" class="btn btn-primary btn-block" value="Upload">
                                    </div>
                                    </form>
                                    <p><c:out value="${newContentStatus}"/></p>
                                    </div>
                                </div>
                                </div>
                                <div class="col-lg-6 col-md-9">
                                <div class="panel panel-default">
                                    <div class="panel-heading">
                                        <h3 class="panel-title"><i class="fa fa-thumb-tack"></i>My Uploaded Pins</h3>
                                    </div>
                                    <div class="panel-body">
                                        <div class="container-fluid">
                                            <div class="masonry">
                                                <c:forEach var="pin" items="${pins}">
                                                <div class="item">
                                                    <img src="${pageContext.request.contextPath}/images?pinName=${pin.pinsPK.name}" style="width:100%">
                                                    <div class="btn-group btn-group-xs">
                                                        <a type="button" class="btn" href="./editPin?pinName=${pin.pinsPK.name}&topicName=${pin.pinsPK.topicsName}" ><i class="fa fa-pencil fa-fw"></i></a>
                                                        <a type="button" class="btn" href="./savePin?pinName=${pin.pinsPK.name}&topicName=${pin.pinsPK.topicsName}"><i class="fa fa-save fa-fw"></i></a>
                                                        <a type="button" class="btn" href="./removePin?pinName=${pin.pinsPK.name}&topicName=${pin.pinsPK.topicsName}"><i class="fa fa-trash fa-fw"></i></a>
                                                    </div>
                                                </div>
                                                </c:forEach>
                                            </div>
                                        </div>
                                <c:if test="${pinStatus != null}">
                                    <div class="btn bg-danger" style=" border-radius: 4px; color:black; width:100%; height: 35px; margin: 0px auto;text-align: center;">
                                    ${pinStatus}</div>
                                </c:if></div>
                                </div>
                                </div>
                            </div></div></div>
                              
                       <div class="row">
                            <div class="col-sm-12">
                                <div class="form-box">
                                    <div class="form-top">
                                        <div class="form-top-left">
                                            <h3>You are logged in 
                                            <c:out value="${sessionScope.loginCount}" /> 
                                                times in the past 2 weeks</h3>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div> 
                    
                </div>
    </div>                                    
    </div>
                            
                     
       
  <script async defer src="//assets.pinterest.com/js/pinit.js"></script>  

<%@ include file='footer.jspf' %>