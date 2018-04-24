<%-- 
    Document   : admin
    Created on : Apr 3, 2018, 10:41:13 PM
    Author     : louisacheong
--%>
<%@ include file='header.jspf' %>
<link rel="stylesheet" href="css/admin.css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
  


<div class="top-content">
    <div class="inner-bg">   	
        <div class="container">
           
        
            
                

        <!-- Navigation -->
        <nav class="navbar navbar-default navbar-static-top" role="navigation" style="margin-bottom: 0">
            <div class="navbar-header"><div class="col-sm-12"><h2><strong>DIY Wedding Planner</h2>
                    <h2>Administrator Dashboard</h2></div></div>
                <div class="col-sm-12">
                  <ul class="nav navbar-top-links navbar-right">
                        <h3><c:out value="${sessionScope.user}"/></h3>
                
               
                
                    
                
                <!-- /.dropdown -->
                <li class="dropdown">
                    <a class="dropdown-toggle" data-toggle="dropdown" href="#">
                        <i class="fa fa-bell fa-fw" style="color:gray"></i> <i class="fa fa-caret-down" style="color:gray"></i>
                    </a>
                    <ul class="dropdown-menu dropdown-alerts">
                        <li>
                            <a href="#">
                                <div>
                                    <i class="fa fa-comment fa-fw"></i> New Comment
                                    <span class="pull-right text-muted small">4 minutes ago</span>
                                </div>
                            </a>
                        </li>
                        <li class="divider"></li>
                        <li>
                            <a href="#">
                                <div>
                                    <i class="fa fa-twitter fa-fw"></i> 3 New Followers
                                    <span class="pull-right text-muted small">12 minutes ago</span>
                                </div>
                            </a>
                        </li>
                        <li class="divider"></li>
                        <li>
                            <a href="#">
                                <div>
                                    <i class="fa fa-envelope fa-fw"></i> Message Sent
                                    <span class="pull-right text-muted small">4 minutes ago</span>
                                </div>
                            </a>
                        </li>
                        <li class="divider"></li>
                        <li>
                            <a href="#">
                                <div>
                                    <i class="fa fa-tasks fa-fw"></i> New Task
                                    <span class="pull-right text-muted small">4 minutes ago</span>
                                </div>
                            </a>
                        </li>
                        <li class="divider"></li>
                        <li>
                            <a href="#">
                                <div>
                                    <i class="fa fa-upload fa-fw"></i> Server Rebooted
                                    <span class="pull-right text-muted small">4 minutes ago</span>
                                </div>
                            </a>
                        </li>
                        <li class="divider"></li>
                        <li>
                            <a class="text-center" href="#">
                                <strong>See All Alerts</strong>
                                <i class="fa fa-angle-right"></i>
                            </a>
                        </li>
                    </ul>
                    <!-- /.dropdown-alerts -->
                </li>
                <!-- /.dropdown -->
                <li class="dropdown">
                    <a class="dropdown-toggle" data-toggle="dropdown" href="#">
                        <i class="fa fa-user fa-fw" style="color:gray"></i> <i class="fa fa-caret-down" style="color:gray"></i>
                    </a>
                    <ul class="dropdown-menu dropdown-user">
                        <li><a href="${pageContext.request.contextPath}/viewAdminProfile"><i class="fa fa-user fa-fw"></i> User Profile</a>
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
            </ul>
            </div>
            

        

        <div id="page-wrapper">
            
            <!-- /.row -->
            <div class="row">
                <div class="col-lg-3 col-md-6">
                    <div class="panel panel-primary">
                        <div class="panel-heading">
                            <div class="row">
                                <div class="col-xs-3">
                                    <i class="fa fa-users fa-5x"></i>
                                </div>
                                <div class="col-xs-9 text-right">
                                    <div class="huge"><c:out value="${onlineUsersCount}"/></div>
                                    <div> Online Users !</div>
                                    <br>
                                    <div class="huge"><c:out value="${regUsersCount}"/></div>
                                    <div>Registered Users !</div>
                                </div>
                            </div>
                        </div>
                        
                    </div>
                </div>
                <div class="col-lg-3 col-md-6">
                    <div class="panel panel-green">
                        <div class="panel-heading">
                            <div class="row">
                                <div class="col-xs-3">
                                    <i class="fa fa-file fa-5x"></i>
                                </div>
                                <div class="col-xs-9 text-right">
                                    <div class="huge">12</div>
                                    <div>New Boards!</div>
                                </div>
                                
                            </div>
                        </div>
                        
                        <div class="panel-footer">
                            <span class="pull-left">Per User</span>
                            <span class="pull-right"><i class="fa fa-arrow-circle-right"></i></span>
                            <div class="clearfix"></div>
                        </div>
                        
                        
                    </div>
                </div>
                <div class="col-lg-3 col-md-6">
                    <div class="panel panel-yellow">
                        <div class="panel-heading">
                            <div class="row">
                                <div class="col-xs-3">
                                    <i class="fa fa-map-pin fa-5x"></i>
                                </div>
                                <div class="col-xs-9 text-right">
                                    <div class="huge">124</div>
                                    <div>New Pins!</div>
                                </div>
                            </div>
                        </div>
                         <div class="panel-footer">
                            <span class="pull-left">Per User</span>
                            <span class="pull-right"><i class="fa fa-arrow-circle-right"></i></span>
                            <div class="clearfix"></div>
                        </div>
                        
                    </div>
                </div>
                <div class="col-lg-3 col-md-6">
                    <div class="panel panel-red">
                        <div class="panel-heading">
                            <div class="row">
                                <div class="col-xs-3">
                                    <i class="fa fa-comments fa-5x"></i>
                                </div>
                                <div class="col-xs-9 text-right">
                                    <div class="huge">5</div>
                                    <br>
                                    <br>
                                    <br>
                                    <div>Topics!</div>
                                </div>
                            </div>
                        </div>
                        
                    </div>
                </div>
            </div>
           
           
            <!-- /.row -->
            <div class="row">
                        <div class="col-lg-6">
                        <div class="panel panel-default">
                            <div class="panel-heading">
                                <h3 class="panel-title"><i class="fa fa-eye"></i> <i class="fa fa-user-times"></i> Users Panel</h3>
                            </div>
                            <div class="panel-body">
                                <div class="input-group custom-search-form" style="width:95%">
                                <form method="POST" action="./searchUserA" accept-charset="UTF-8" role="form" id="custom-search-form" class="custom-search-form">
                                <input type="text" name="searchtext" class="form-control" placeholder="Search...">
                                <span class="input-group-btn">
                                    <br>
                                <input class="btn btn-default" type="submit" value="Search"><i class="fa fa-search"></i>
                                    
                                
                                </span>
                                </form>
                                </div>
                            <table id="userTable">
                                <c:forEach var="foundUser" items="${foundUser}" varStatus="iter">
                                    <tr class="${((iter.index % 2) == 0) ? 'lightBlue' : 'white'}">
                                        <td>
                                            <h3><img src="${initParam.userImagePath}${foundUser.username}.jpg"
                                                     alt="${foundUser.username}" class="img-rounded img-responsive" height="500px" width="386px"><c:out value="${foundUser.email}"></c:out></h3>
                                                     <h3><c:out value="${foundUser.username}"/></h3>
                                                     <h4><c:out value="${foundUser.country}"/></h4>
                                            <p>
                                            
                                            <a href="${pageContext.request.contextPath}/removeUser" class="btn btn-xs btn-default"><span class="glyphicon glyphicon-remove"></span>Remove User</a>
                                            <c:choose>
                                            <c:when test="${not foundUser.isAdmin}">
                                                <a href="${pageContext.request.contextPath}/promoteUser" class="btn btn-xs btn-default"><span class="glyphicon glyphicon-eye-open"></span>Promote to Admin</a>
                                            </c:when>
                                            <c:otherwise>
                                                <a href="${pageContext.request.contextPath}/demoteUser" class="btn btn-xs btn-default"><span class="glyphicon glyphicon-eye-close"></span>Demote to User</a>
                                            </c:otherwise>
                                            </c:choose>
                                                
                                            </p>
                                        </td>         
                                    </tr>
                                </c:forEach>
                                </table>
                                <c:if test="${searcherror != null}">
                                    <div class="bg-danger" style="padding: 15px; border-radius: 4px; color:black; max-width: 500px; margin: 0px auto;">
                                    ${searcherror}</div>
                                </c:if>
                                
                            </div>
                        </div>
                        </div>
                        <div class="col-lg-6">
                        <div class="panel panel-default">
                            <div class="panel-heading">
                                <h3 class="panel-title"><i class="fa fa-upload"></i> Content Panel</h3>
                            </div>
                            <div class="panel-body">
                                <form action="./createTopic" method="post">
                                    <input type="text" name="newtopic" class="form-control" placeholder="Topic Name...">
                                    
                                    <br>
                                    <input class="btn btn-default" type="submit" value="Create"><i class="fa fa-plus-circle"></i>
                                </form>
                                
                                <p><c:out value="${newTopicStatus}"/></p>
                                
                                <p>or</p>
                                    
                                <form action="./uploadContentA" method="post" enctype="multipart/form-data">    
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
                                    
                                    <p class="help-block">Pin image will be added into the topic selected.
                                        <a href="./img/topic/WeddingImg1.png"</p>
                                </div>
                                <div>
                                    <input type="submit" class="btn btn-primary" value="Upload">
                                </div>
                                </form>
                                <p><c:out value="${newContentStatus}"/></p>
                                 
                                <!-- TODO logic to create topics and add pins -->
                            </div>
                        </div>
                    </div>
            </div>
                    <div class="row">
                    <div class="col-sm-12">
                    <div class="form-box">
                        <div class="form-top">
                            <div class="form-top-left">
                                                <h3>You are logged in 
                                                <c:out value="${loginCount}" /> 
                                                times in the past 2 weeks</h3>
                                                </div>
                        </div>
                    </div>
                    </div></div></div></div></div></div>
                       
                        
       
   
<script async defer src="https://maps.googleapis.com/maps/api/js?key=AIzaSyCSfmXDopoIVNIHaNZl-nOZhxaVT2cZiXc&callback=initMap"></script>
<%@ include file='footer.jspf' %>