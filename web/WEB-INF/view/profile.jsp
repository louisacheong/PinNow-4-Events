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
                  <ul class="nav navbar-top-links navbar-right">
                        <h3 style="color:gray;"><c:out value="${sessionScope.user}"/></h3>
                        <p>
                            <a data-pin-do="buttonFollow" href="https://www.pinterest.com/pinterest/"><c:out value="${sessionScope.followerCount}"/> Followers</a>
                            <a data-pin-do="buttonFollow" href="https://www.pinterest.com/pinterest/"><c:out value="${sessionScope.followedCount}"/> Followed</a>
                        </p>
               
                <!-- /.dropdown -->
                <li class="dropdown">
                    <a class="dropdown-toggle" data-toggle="dropdown" href="#">
                        <i class="fa fa-tasks fa-fw" style="color:gray"></i> <i class="fa fa-caret-down"></i>
                    </a>
                    <ul class="dropdown-menu dropdown-tasks">
                        <li>
                            <a href="#">
                                <div>
                                    <p>
                                        <strong>Task 1</strong>
                                        <span class="pull-right text-muted">40% Complete</span>
                                    </p>
                                    <div class="progress progress-striped active">
                                        <div class="progress-bar progress-bar-success" role="progressbar" aria-valuenow="40" aria-valuemin="0" aria-valuemax="100" style="width: 40%">
                                            <span class="sr-only">40% Complete (success)</span>
                                        </div>
                                    </div>
                                </div>
                            </a>
                        </li>
                        <li class="divider"></li>
                        <li>
                            <a href="#">
                                <div>
                                    <p>
                                        <strong>Task 2</strong>
                                        <span class="pull-right text-muted">20% Complete</span>
                                    </p>
                                    <div class="progress progress-striped active">
                                        <div class="progress-bar progress-bar-info" role="progressbar" aria-valuenow="20" aria-valuemin="0" aria-valuemax="100" style="width: 20%">
                                            <span class="sr-only">20% Complete</span>
                                        </div>
                                    </div>
                                </div>
                            </a>
                        </li>
                        <li class="divider"></li>
                        <li>
                            <a href="#">
                                <div>
                                    <p>
                                        <strong>Task 3</strong>
                                        <span class="pull-right text-muted">60% Complete</span>
                                    </p>
                                    <div class="progress progress-striped active">
                                        <div class="progress-bar progress-bar-warning" role="progressbar" aria-valuenow="60" aria-valuemin="0" aria-valuemax="100" style="width: 60%">
                                            <span class="sr-only">60% Complete (warning)</span>
                                        </div>
                                    </div>
                                </div>
                            </a>
                        </li>
                        <li class="divider"></li>
                        <li>
                            <a href="#">
                                <div>
                                    <p>
                                        <strong>Task 4</strong>
                                        <span class="pull-right text-muted">80% Complete</span>
                                    </p>
                                    <div class="progress progress-striped active">
                                        <div class="progress-bar progress-bar-danger" role="progressbar" aria-valuenow="80" aria-valuemin="0" aria-valuemax="100" style="width: 80%">
                                            <span class="sr-only">80% Complete (danger)</span>
                                        </div>
                                    </div>
                                </div>
                            </a>
                        </li>
                        <li class="divider"></li>
                        <li>
                            <a class="text-center" href="#">
                                <strong>See All Tasks</strong>
                                <i class="fa fa-angle-right" style="color:gray"></i>
                            </a>
                        </li>
                    </ul>
                    <!-- /.dropdown-tasks -->
                </li>
                <!-- /.dropdown -->
                <li class="dropdown">
                    <a class="dropdown-toggle" data-toggle="dropdown" href="#">
                        <i class="fa fa-bell fa-fw" style="color:gray"></i> <i class="fa fa-caret-down"></i>
                    </a>
                    <ul class="dropdown-menu dropdown-alerts">
                        <li>
                            <a href="#">
                                <div>
                                    <i class="fa fa-comment fa-fw" style="color:gray"></i> New Comment
                                    <span class="pull-right text-muted small">4 minutes ago</span>
                                </div>
                            </a>
                        </li>
                        <li class="divider"></li>
                        <li>
                            <a href="#">
                                <div>
                                    <i class="fa fa-twitter fa-fw" style="color:gray;"></i> 3 New Followers
                                    <span class="pull-right text-muted small">12 minutes ago</span>
                                </div>
                            </a>
                        </li>
                        <li class="divider"></li>
                        <li>
                            <a href="#">
                                <div>
                                    <i class="fa fa-envelope fa-fw" style="color:gray"></i> Message Sent
                                    <span class="pull-right text-muted small">4 minutes ago</span>
                                </div>
                            </a>
                        </li>
                        <li class="divider"></li>
                        <li>
                            <a href="#">
                                <div>
                                    <i class="fa fa-tasks fa-fw" style="color:gray"></i> New Task
                                    <span class="pull-right text-muted small">4 minutes ago</span>
                                </div>
                            </a>
                        </li>
                        <li class="divider"></li>
                        <li>
                            <a href="#">
                                <div>
                                    <i class="fa fa-upload fa-fw" style="color:gray"></i> Server Rebooted
                                    <span class="pull-right text-muted small">4 minutes ago</span>
                                </div>
                            </a>
                        </li>
                        <li class="divider"></li>
                        <li>
                            <a class="text-center" href="#">
                                <strong>See All Alerts</strong>
                                <i class="fa fa-angle-right" style="color:gray"></i>
                            </a>
                        </li>
                    </ul>
                    <!-- /.dropdown-alerts -->
                </li>
                <!-- /.dropdown -->
                <li class="dropdown">
                    <a class="dropdown-toggle" data-toggle="dropdown" href="#">
                        <i class="fa fa-user fa-fw" style="color:gray"></i> <i class="fa fa-caret-down"></i>
                    </a>
                    <ul class="dropdown-menu dropdown-user">
                        <li><a href="${pageContext.request.contextPath}/viewProfile"><i class="fa fa-user fa-fw"></i> User Profile</a>
                        </li>
                        <li><a href="${pageContext.request.contextPath}/editUser"><i class="fa fa-gear fa-fw"></i> Settings</a>
                        </li>
                        <li class="divider"></li>
                        <li><a href="${pageContext.request.contextPath}/Logout"><i class="fa fa-sign-out fa-fw"></i> Logout</a>
                        </li>
                    </ul>
                    <!-- /.dropdown-user -->
                </li>
                <!-- /.dropdown -->
                  </ul></div></div>
                    <div class="col-sm-12">
                        <div class="row"> 
                        <div class="jumbotron">
                            <div class="row">
                                <div class="col-sm-6 col-md-6">    
                                <div class="input-group custom-search-form">
                                <form method="POST" action="./searchUserandBoard" accept-charset="UTF-8" role="form" id="custom-search-form" class="custom-search-form">
                                <input type="text" name="searchtext" class="form-control" placeholder="Search for User...">
                                <span class="input-group-btn">
                                <input class="btn btn-default" type="submit" value="Search">
                                    <i class="fa fa-search"></i>
                                
                                </span>
                                </form>
                                </div></div>
                                <div class="col-sm-2 col-md-2">
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
                                            <a href="${pageContext.request.contextPath}/followUser?following=<c:out value="${foundUser.email}"/>" class="btn btn-xs btn-default"><span class="glyphicon glyphicon-heart"></span> Follow</a>
                                            <a href="${pageContext.request.contextPath}/unfollowUser?following=<c:out value="${foundUser.email}"/>" class="btn btn-xs btn-default"><span class="glyphicon glyphicon-ban-circle"></span> Unfollow</a>
                                            </p>
                                        </td>         
                                    </tr>
                                </c:forEach>
                                </table>
                                </c:if>
                                <c:if test= "${foundBoard != null}">
                                <table id="boardTable" width="100%" class="table-hover table-striped">
                                    <c:forEach var="board" items="${foundBoard}" varStatus="status">
                                        <tr>
                                        <td>
                                            <h3><c:out value="${board.pinboardsPK.name}"></c:out></h3>
                                        </td>
                                        <td style="text-align: center;">
                                            <a href="${pageContext.request.contextPath}/followBoard?following=<c:out value="${board.pinboardsPK.userEmail}"/>&board=${board.pinboardsPK.name}" class="btn btn-xs btn-default"><span class="glyphicon glyphicon-heart"></span> Follow</a>
                                        </td>
                                        <td style="text-align: center;">
                                            <a href="${pageContext.request.contextPath}/unfollowBoard?following=<c:out value="${board.pinboardsPK.userEmail}"/>&board=${board.pinboardsPK.name}" class="btn btn-xs btn-default"><span class="glyphicon glyphicon-ban-circle"></span> Unfollow</a>
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
                                                    <img src="${pageContext.request.contextPath}/images?pinName=${p.pinsPK.name}"></div>
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