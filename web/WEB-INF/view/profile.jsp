<%-- 
    Document   : userProfile
    Created on : Apr 3, 2018, 11:41:13 PM
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
            <div class="navbar-header"><div class="col-sm-12"><h2><strong>Wedding PinApp</h2>
                    <h2>User Profile</h2></div></div>
            <div class="navbar-top-links">
                
            
                <div class="col-sm-12">
                   <div class="row"> 
                  <ul class="nav navbar-top-links navbar-right">
                        <h3 style="color:gray;"><c:out value="${sessionScope.user}"/></h3>
                <li class="dropdown">
                    <a class="dropdown-toggle" data-toggle="dropdown" href="#">
                        <i class="fa fa-envelope fa-fw" style="color:gray"></i> <i class="fa fa-caret-down"></i>
                    </a>
                       <ul class="dropdown-menu dropdown-messages">
                        <li>
                            <a href="#">
                                <div>
                                    <strong>John Smith</strong>
                                    <span class="pull-right text-muted">
                                        <em>Yesterday</em>
                                    </span>
                                </div>
                                <div>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Pellentesque eleifend...</div>
                            </a>
                        </li>
                        <li class="divider"></li>
                        <li>
                            <a href="#">
                                <div>
                                    <strong>John Smith</strong>
                                    <span class="pull-right text-muted">
                                        <em>Yesterday</em>
                                    </span>
                                </div>
                                <div>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Pellentesque eleifend...</div>
                            </a>
                        </li>
                        <li class="divider"></li>
                        <li>
                            <a href="#">
                                <div>
                                    <strong>John Smith</strong>
                                    <span class="pull-right text-muted">
                                        <em>Yesterday</em>
                                    </span>
                                </div>
                                <div>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Pellentesque eleifend...</div>
                            </a>
                        </li>
                        <li class="divider"></li>
                        <li>
                            <a class="text-center" href="#">
                                <strong>Read All Messages</strong>
                                <i class="fa fa-angle-right" style="color:gray"></i>
                            </a>
                        </li>
                    </ul>
                     
                      
                    <!-- /.dropdown-messages -->
                </li>
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
                        <li><a href="#"><i class="fa fa-user fa-fw"></i> User Profile</a>
                        </li>
                        <li><a href="${pageContext.request.contextPath}/editUser"><i class="fa fa-gear fa-fw"></i> Settings</a>
                        </li>
                        <li class="divider"></li>
                        <li><a href="index.jsp"><i class="fa fa-sign-out fa-fw"></i> Logout</a>
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
                            <h3 style="color:gray"><c:out value="${sessionScope.userName}"/>UserName</h3>
                            <h3 style="color:gray"><c:out value="${sessionScope.followersCount}"/><a data-pin-do="buttonFollow" href="https://www.pinterest.com/pinterest/">Followers</a></h3>
                            <h3 style="color:gray"><c:out value="${sessionScope.followersCount}"/><a data-pin-do="buttonFollow" href="https://www.pinterest.com/pinterest/">Followed</a></h3>

                            </div>
                        </div> 
                        </div>
                    </div>
                    <div class="col-sm-12">
                        <ul class="nav nav-pills">
                            <li class="active">
                                <a href="#boards" data-toggle="pill" aria-expanded="false">Boards</a>
                            </li>
                            <li class>
                                <a href="#pins" data-toggle="pill" aria-expanded="false">Pins</a>
                            </li>
                            <li class>
                                <a href="#topics" data-toggle="pill" aria-expanded="false">Topics</a>
                            </li>
                        </ul>
                        <div class="tab-content">
                            <div class="tab-pane fade in active" id="boards">
                                <h4>Boards Pane</h4>
                                <p><a data-pin-do="embedBoard" data-pin-board-width="280" data-pin-scale-height="100" data-pin-scale-width="60" href="https://www.pinterest.com/l_cheong0283/dream-wedding/"></a></p>
                                <p><a data-pin-do="embedBoard" data-pin-board-width="280" data-pin-scale-height="100" data-pin-scale-width="60" href="https://www.pinterest.com/l_cheong0283/wedding-food-drinks"></a></p>  
                                <p><a data-pin-do="embedBoard" data-pin-board-width="280" data-pin-scale-height="100" data-pin-scale-width="60" href="https://www.pinterest.com/l_cheong0283/wedding-dresses/"></a></p>
                                    <!-- /.row -->
                                <div class="row">
                                    SECRET BOARD
                                </div>
                                
                            </div>
                            <div class="tab-pane fade" id="pins">
                                <h4>Pins Pane</h4>
                                <p><a data-pin-do="embedPin" href="https://www.pinterest.com/pin/576601558516368453/"></a></p>
                            </div>
                            <div class="tab-pane fade" id="topics">
                                <h4>Topics Pane</h4>
                                <p></p>
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
                                    </div>
                                </div> 
                    </div>
                </div>
                            
                
                    
            

        

        
            
        
                       
                        
       
  <script async defer src="//assets.pinterest.com/js/pinit.js"></script>  

<%@ include file='footer.jspf' %>