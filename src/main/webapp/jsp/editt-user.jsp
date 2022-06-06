<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: hongh
  Date: 03/06/2022
  Time: 2:03 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="../../css/homepage.css">
    <title>Profile - Social Book</title>
    <script src="https://kit.fontawesome.com/ef7e2b893b.js" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css" integrity="sha384-zCbKRCUGaJDkqS1kPbPd7TveP5iyJE0EjAuZQTgFLD2ylzuqKfdKlfG/eSrtxUkn" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-fQybjgWLrvvRgtW6bFlB7jaZrFsaBXjsOMm/tB9LTS58ONXgqbR9W8oWht/amnpF" crossorigin="anonymous"></script>

</head>

<body>
<nav class="navbar">
    <%--    <div class="nav-left"><img class="logo" src="images/logo.png" alt="">--%>
    <div class="nav-left"><a href="/users?action=homepage"><img class="logo" src="../../image/logofakebook.jpg"
                                                                alt="logoFB"></a>
        <ul class="navlogo">
            <p style="color: #0a0a0a">
                <a style="color: #0a0a0a" href="/users?action=my-profile&id=${currentUser.id}">
                    ${currentUser.fullName}
                </a>
            </p>
        </ul>
        <div class="profile-image online" onclick="UserSettingToggle()">
            <img src="${currentUser.avatar}" alt="">
        </div>
    </div>
    <div class="nav-right">
        <div class="search-box">
            <img src="jsp/homepage/images/search.png" alt="">
            <input type="text" placeholder="Search">
        </div>
    </div>
    <div class="user-settings">
        <div class="profile-darkButton">
            <div class="user-profile">
                <img src="jsp/homepage/images/profile-pic.png" alt="">
                <div>
                    <p> ${currentUser.fullName}</p>
                    <a href="/users?action=my-profile&id=${currentUser.id}">See your profile</a>
                </div>
            </div>
            <div id="dark-button" onclick="darkModeON()">
                <span></span>
            </div>
        </div>
        <hr>
        <div class="user-profile">
            <img src="jsp/homepage/images/feedback.png" alt="">
            <div>
                <p> Give Feedback</p>
                <a href="#">Help us to improve</a>
            </div>
        </div>
        <hr>
        <div class="settings-links">
            <img src="jsp/homepage/images/setting.png" alt="" class="settings-icon">
            <a href="#">Settings & Privary <img src="jsp/homepage/images/arrow.png" alt=""></a>
        </div>

        <div class="settings-links">
            <img src="jsp/homepage/images/help.png" alt="" class="settings-icon">
            <a href="#">Help & Support <img src="jsp/homepage/images/arrow.png" alt=""></a>
        </div>

        <div class="settings-links">
            <img src="jsp/homepage/images/Display.png" alt="" class="settings-icon">
            <a href="#">Display & Accessibility <img src="jsp/homepage/images/arrow.png" alt=""></a>
        </div>

        <div class="settings-links">
            <img src="jsp/homepage/images/logout.png" alt="" class="settings-icon">
            <a href="#">Logout <img src="jsp/homepage/images/arrow.png" alt=""></a>
        </div>

    </div>
</nav>

<!-- profile-page-------------------------- -->


<div class="profile-container">
    <img src="jsp/homepage/images/cover.png" class="coverImage" alt="">
    <div class="dashboard">
        <div class="left-dashboard">
            <img src="${currentUser.avatar}" class="dashboard-img" alt="avt">
            <div class="left-dashboard-info">
                <h3>${currentUser.fullName}</h3>
                <p>${myFriends.size()} Friends</p>
                <div class="mutual-friend-images">
                    <div class="first-friend">
                        <c:forEach items="${myFriends}" var="friend">
                            <img src="${friend.avatar}" alt="avt">
                        </c:forEach>
                    </div>
                    <%--                    <img src="jsp/homepage/images/member-1.png" alt="">--%>
                    <%--                    <img src="jsp/homepage/images/member-2.png" alt="">--%>
                    <%--                    <img src="jsp/homepage/images/member-3.png" alt="">--%>
                    <%--                    <img src="jsp/homepage/images/member-5.png" alt="">--%>
                </div>
            </div>
        </div>
        <div class="right-dashboard-info">
            <div class="right-dashboard-info-top">
<%--                <form action="?????" method="post">--%>
<%--                    <a class="btn btn-secondary" href=""><i class="fas fa-user-plus"></i>Update</a>--%>
<%--                </form>--%>
                <%--                <button type="button"><i class="far fa-envelope"></i> messages</button>--%>
            </div>
            <div class="right-div-single-logo"><a href="#"> <i class="fas fa-ellipsis-h"></i></a></div>
        </div>
    </div>


    <div class="container content-profile-container">
        <div class="left-sidebar profile-left-sidebar">
            <div class="left-profile-sidebar-top">
                <div class="intro-bio">
                    <h4>intro</h4>
                    <p>Belive in yourself and you do unbelievable things <i class="far fa-smile-beam"></i></p>
                    <hr>
                </div>
                <div class="background-details">
                    <a href="#"><i class="fas fa-briefcase"></i>
                        <p>Freelancer on Fiverr</p>
                    </a>
                    <a href="#"><i class="fas fa-graduation-cap"></i>
                        <p>Studied bsc at Codegym</p>
                    </a>
                    <a href="#"><i class="fas fa-user-graduate"></i>
                        <p>Went to Technical School & Collage</p>
                    </a>
                    <a href="#"><i class="fas fa-home"></i>
                        <p>Cộng đồng người Việt sinh sống tại Hà Nội</p>
                    </a>
                    <a href="#"><i class="fas fa-map-marker-alt"></i>
                        <p>From Chittagong, Bangladesh</p>
                    </a>
                </div>
            </div>

            <div class="left-profile-sidebar-top gallery">
                <div class="heading-link profile-heading-link">
                    <h4>Photos</h4>
                    <a href="">All Photos</a>
                </div>

                <div class="gallery-photos">
                    <div class="gallery-photos-rowFirst">
                        <img src="jsp/homepage/images/photo1.png" alt="">
                        <img src="jsp/homepage/images/photo2.png" alt="">
                        <img src="jsp/homepage/images/photo3.png" alt="">

                        <img src="jsp/homepage/images/photo4.png" alt="">
                        <img src="jsp/homepage/images/photo5.png" alt="">
                        <img src="jsp/homepage/images/photo6.png" alt="">
                    </div>
                </div>
            </div>

            <div class="left-profile-sidebar-top gallery">
                <div class="heading-link profile-heading-link">
                    <h4>Friends</h4>
                    <a href="">All Friends</a>
                </div>

                <div class="gallery-photos">
                    <div class="gallery-photos-rowFirst">
                        <c:forEach items="${myFriends}" var="friend">
                            <div class="first-friend">
                                <img src="${friend.avatar}" alt="avt">
                                <p><a href="/users?action=profile&id=${friend.id}">${friend.fullName}</a></p>
                            </div>
                        </c:forEach>
                    </div>
                </div>
            </div>

        </div>
<%--        <form action="/users" method="post">--%>
<%--            <input  type="hidden" name="action" value="edit-user">--%>
<%--            <input type="hidden" name="id" value="${currentUser.id}">--%>
<%--            <div>--%>
<%--                <input class="form-control" type="text" placeholder="full_name" name="full_name">--%>
<%--            </div>--%>
<%--            <div style="width: 100%;">--%>
<%--                <input type="text" placeholder="email" name="email">--%>

<%--            </div>--%>
<%--            <div>--%>
<%--                <input type="text" placeholder="avatar" name="avatar">--%>
<%--            </div>--%>
<%--            <div style="">--%>
<%--                <input type="date" placeholder="Date-of-birth" name="date_of_birth">--%>
<%--                <input type="text" placeholder="password" name="password">--%>
<%--                <button>Cập nhập thông tin</button>--%>
<%--            </div>--%>

<%--        </form>--%>
        <form style="margin-right: auto" action="/users" method="post">
            <input  type="hidden" name="action" value="edit-user">
            <input type="hidden" name="id" value="${currentUser.id}">
            <div  class="form-row">
                <div class="form-group col-md-6">
                    <label for="inputEmail4">Email</label>
                    <input type="text" class="form-control" id="inputEmail4" name="email">
                </div>
                <div class="form-group col-md-6">
                    <label for="inputPassword4">Password</label>
                    <input type="password" class="form-control" id="inputPassword4" name="password">
                </div>
            </div>
            <div class="form-group">
                <label for="inputAddress">FullName</label>
                <input type="text" class="form-control" id="inputAddress" placeholder="Full Name" name="full_name">
            </div>
            <div class="form-group">
                <label for="inputAddress2">Avatar</label>
                <input type="text" class="form-control" id="inputAddress2" placeholder="Avatar" name="avatar">
            </div>
            <div class="form-row">
                <div class="form-group col-md-6">
                    <label for="inputCity">Date of birth</label>
                    <input type="date" class="form-control" id="inputCity" name="date_of_birth">
                </div>
<%--                <div class="form-group col-md-4">--%>
<%--                    <label for="inputState">State</label>--%>
<%--                    <select id="inputState" class="form-control">--%>
<%--                        <option selected>Choose...</option>--%>
<%--                        <option>...</option>--%>
<%--                    </select>--%>
<%--                </div>--%>
<%--                <div class="form-group col-md-2">--%>
<%--                    <label for="inputZip">Zip</label>--%>
<%--                    <input type="text" class="form-control" id="inputZip">--%>
<%--                </div>--%>
            </div>
            <div class="form-group">
                <div class="form-check">
                    <input class="form-check-input" type="checkbox" id="gridCheck">
                    <label class="form-check-label" for="gridCheck">
                    </label>
                </div>
            </div>
            <button type="submit" class="btn btn-primary">Confirm</button>
        </form>

        <!-- main-content------- -->

<%--        <div class="content-area profile-content-area">--%>
<%--            <div class="write-post-container">--%>
<%--                <div class="user-profile">--%>
<%--                    <img src="${currentUser.avatar}" alt="">--%>
<%--                    <div>--%>
<%--                        <p> ${currentUser.fullName}</p>--%>
<%--                        <small>Public <i class="fas fa-caret-down"></i></small>--%>
<%--                    </div>--%>
<%--                </div>--%>

<%--                <div class="post-upload-textarea">--%>
<%--                    <textarea name="" placeholder="What's on your mind, Alex?" id="" cols="30" rows="3"></textarea>--%>
<%--                    <div class="add-post-links">--%>
<%--                        <a href="#"><img src="jsp/homepage/images/live-video.png" alt="">Live Video</a>--%>
<%--                        <a href="#"><img src="jsp/homepage/images/photo.png" alt="">Photo/Video</a>--%>
<%--                        <a href="#"><img src="jsp/homepage/images/feeling.png" alt="">Feeling Activity</a>--%>
<%--                    </div>--%>
<%--                </div>--%>
<%--            </div>--%>
<%--            <c:forEach items="${myPosts}" var="post">--%>
<%--                <div class="status-field-container write-post-container">--%>
<%--                    <div class="user-profile-box">--%>
<%--                        <div class="user-profile">--%>
<%--                            <img src="${post.getUser().getAvatar()}" alt="">--%>
<%--                            <div>--%>
<%--                                <p> ${post.getUser().getFullName()}</p>--%>
<%--                                <small>${post.time}</small>--%>
<%--                            </div>--%>
<%--                        </div>--%>
<%--                        <div>--%>
<%--                            <a href="#"><i class="fas fa-ellipsis-v"></i></a>--%>
<%--                        </div>--%>
<%--                    </div>--%>
<%--                    <div class="status-field">--%>
<%--                        <p>${post.content}</p>--%>
<%--                        <img src="${post.image}" alt="">--%>
<%--                    </div>--%>
<%--                    <div class="post-reaction">--%>
<%--                        <div class="activity-icons">--%>
<%--                            <div>--%>
<%--                                <form action="/posts" method="post">--%>
<%--                                    <input type="hidden" name="action" value="like">--%>
<%--                                    <input type="hidden" name="postId" value="${post.id}">--%>
<%--                                    <button>--%>
<%--                                        <img src="jsp/homepage/images/like.png" alt="">--%>
<%--                                    </button>--%>
<%--                                        ${post.likeCount} likes--%>
<%--                                </form>--%>
<%--                            </div>--%>
<%--                            <div><img src="jsp/homepage/images/comments.png" alt="">${post.commentCount} comments</div>--%>
<%--                            <div><img src="jsp/homepage/images/share.png" alt="">35</div>--%>
<%--                        </div>--%>
<%--                        <div class="post-profile-picture">--%>
<%--                            <img src="${currentUser.avatar}" alt=""> <i class=" fas fa-caret-down"></i>--%>
<%--                        </div>--%>
<%--                    </div>--%>
<%--                    <c:forEach items="${post.getComments()}" var="comment">--%>
<%--                        <div>--%>
<%--                            <div class="user-profile"><img src="${comment.getUser().getAvatar()}" alt="">--%>
<%--                                <div>--%>
<%--                                    <p> ${comment.getUser().getFullName()}</p>--%>
<%--                                    <small>${comment.time}</small>--%>
<%--                                </div>--%>
<%--                            </div>--%>
<%--                            <div class="status-field"><p>${comment.content}</p></div>--%>
<%--                        </div>--%>
<%--                    </c:forEach>--%>
<%--                    <form action="/posts" method="post">--%>
<%--                        <input type="hidden" name="action" value="comment">--%>
<%--                        <input type="hidden" name="postId" value="${post.id}">--%>
<%--                        <div class="post-upload-textarea">--%>
<%--                    <textarea name="commentContent" placeholder="Write a comment" cols="30"--%>
<%--                              rows="1"></textarea>--%>
<%--                            <button>Comment</button>--%>
<%--                        </div>--%>
<%--                    </form>--%>

<%--                </div>--%>
<%--            </c:forEach>--%>
            <%--            <div class="status-field-container write-post-container">--%>
            <%--                <div class="user-profile-box">--%>
            <%--                    <div class="user-profile">--%>
            <%--                        <img src="images/profile-pic.png" alt="">--%>
            <%--                        <div>--%>
            <%--                            <p> Alex Carry</p>--%>
            <%--                            <small>August 13 1999, 09.18 pm</small>--%>
            <%--                        </div>--%>
            <%--                    </div>--%>
            <%--                    <div>--%>
            <%--                        <a href="#"><i class="fas fa-ellipsis-v"></i></a>--%>
            <%--                    </div>--%>
            <%--                </div>--%>
            <%--                <div class="status-field">--%>
            <%--                    <p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Corporis dolores praesentium dicta--%>
            <%--                        laborum nihil accusantium odit laboriosam, sed sit autem! <a--%>
            <%--                                href="#">#This_Post_is_Better!!!!</a>--%>
            <%--                    </p>--%>
            <%--                    <img src="jsp/homepage/images/feed-image-1.png" alt="">--%>

            <%--                </div>--%>
            <%--                <div class="post-reaction">--%>
            <%--                    <div class="activity-icons">--%>
            <%--                        <div><img src="jsp/homepage/images/like-blue.png" alt="">120</div>--%>
            <%--                        <div><img src="jsp/homepage/images/comments.png" alt="">52</div>--%>
            <%--                        <div><img src="jsp/homepage/images/share.png" alt="">35</div>--%>
            <%--                    </div>--%>
            <%--                    <div class="post-profile-picture">--%>
            <%--                        <img src="jsp/homepage/images/profile-pic.png " alt=""> <i class=" fas fa-caret-down"></i>--%>
            <%--                    </div>--%>
            <%--                </div>--%>
            <%--            </div>--%>
            <%--            <div class="status-field-container write-post-container">--%>
            <%--                <div class="user-profile-box">--%>
            <%--                    <div class="user-profile">--%>
            <%--                        <img src="jsp/homepage/images/profile-pic.png" alt="">--%>
            <%--                        <div>--%>
            <%--                            <p> Alex Carry</p>--%>
            <%--                            <small>August 13 1999, 09.18 pm</small>--%>
            <%--                        </div>--%>
            <%--                    </div>--%>
            <%--                    <div>--%>
            <%--                        <a href="#"><i class="fas fa-ellipsis-v"></i></a>--%>
            <%--                    </div>--%>
            <%--                </div>--%>
            <%--                <div class="status-field">--%>
            <%--                    <p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Corporis dolores praesentium dicta--%>
            <%--                        laborum nihil accusantium odit laboriosam, sed sit autem! <a--%>
            <%--                                href="#">#This_Post_is_Bigger!!!!</a>--%>
            <%--                    </p>--%>
            <%--                    <img src="jsp/homepage/images/feed-image-2.png" alt="">--%>

            <%--                </div>--%>
            <%--                <div class="post-reaction">--%>
            <%--                    <div class="activity-icons">--%>
            <%--                        <div><img src="jsp/homepage/images/like-blue.png" alt="">120</div>--%>
            <%--                        <div><img src="jsp/homepage//comments.png" alt="">52</div>--%>
            <%--                        <div><img src="jsp/homepage/images/share.png" alt="">35</div>--%>
            <%--                    </div>--%>
            <%--                    <div class="post-profile-picture">--%>
            <%--                        <img src="jsp/homepage/images/profile-pic.png " alt=""> <i class=" fas fa-caret-down"></i>--%>
            <%--                    </div>--%>
            <%--                </div>--%>
            <%--            </div>--%>
            <%--            <div class="status-field-container write-post-container">--%>
            <%--                <div class="user-profile-box">--%>
            <%--                    <div class="user-profile">--%>
            <%--                        <img src="jsp/homepage/images/profile-pic.png" alt="">--%>
            <%--                        <div>--%>
            <%--                            <p> Alex Carry</p>--%>
            <%--                            <small>August 13 1999, 09.18 pm</small>--%>
            <%--                        </div>--%>
            <%--                    </div>--%>
            <%--                    <div>--%>
            <%--                        <a href="#"><i class="fas fa-ellipsis-v"></i></a>--%>
            <%--                    </div>--%>
            <%--                </div>--%>
            <%--                <div class="status-field">--%>
            <%--                    <p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Corporis dolores praesentium dicta--%>
            <%--                        laborum nihil accusantium odit laboriosam, sed sit autem! <a--%>
            <%--                                href="#">#This_Post_is_faster!!!!</a>--%>
            <%--                    </p>--%>
            <%--                    <img src="jsp/homepage/images/feed-image-3.png" alt="">--%>

            <%--                </div>--%>
            <%--                <div class="post-reaction">--%>
            <%--                    <div class="activity-icons">--%>
            <%--                        <div><img src="jsp/homepage/images/like-blue.png" alt="">120</div>--%>
            <%--                        <div><img src="jsp/homepage/images/comments.png" alt="">52</div>--%>
            <%--                        <div><img src="jsp/homepage/images/share.png" alt="">35</div>--%>
            <%--                    </div>--%>
            <%--                    <div class="post-profile-picture">--%>
            <%--                        <img src="jsp/homepage/images/profile-pic.png " alt=""> <i class=" fas fa-caret-down"></i>--%>
            <%--                    </div>--%>
            <%--                </div>--%>
            <%--            </div>--%>
            <%--            <div class="status-field-container write-post-container">--%>
            <%--                <div class="user-profile-box">--%>
            <%--                    <div class="user-profile">--%>
            <%--                        <img src="images/profile-pic.png" alt="">--%>
            <%--                        <div>--%>
            <%--                            <p> Alex Carry</p>--%>
            <%--                            <small>August 13 1999, 09.18 pm</small>--%>
            <%--                        </div>--%>
            <%--                    </div>--%>
            <%--                    <div>--%>
            <%--                        <a href="#"><i class="fas fa-ellipsis-v"></i></a>--%>
            <%--                    </div>--%>
            <%--                </div>--%>
            <%--                <div class="status-field">--%>
            <%--                    <p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Corporis dolores praesentium dicta--%>
            <%--                        laborum nihil accusantium odit laboriosam, sed sit autem! <a--%>
            <%--                                href="#">#This_Post_is_perfect!!!!</a>--%>
            <%--                    </p>--%>
            <%--                    <img src="jsp/homepage/images/feed-image-4.png" alt="">--%>

            <%--                </div>--%>
            <%--                <div class="post-reaction">--%>
            <%--                    <div class="activity-icons">--%>
            <%--                        <div><img src="jsp/homepage/images/like-blue.png" alt="">120</div>--%>
            <%--                        <div><img src="jsp/homepage/images/comments.png" alt="">52</div>--%>
            <%--                        <div><img src="jsp/homepage/images/share.png" alt="">35</div>--%>
            <%--                    </div>--%>
            <%--                    <div class="post-profile-picture">--%>
            <%--                        <img src="jsp/homepage/images/profile-pic.png " alt=""> <i class=" fas fa-caret-down"></i>--%>
            <%--                    </div>--%>
            <%--                </div>--%>
            <%--            </div>--%>
<%--            <button type="button" class="btn-LoadMore" onclick="LoadMoreToggle()">Load More</button>--%>
        </div>
    </div>
</div>
<footer id="footer">
    <p>&copy; Copyright 2021 - Socialbook All Rights Reserved</p>
</footer>
<script src="../../js/homepage.js"></script>
</body>

</html>
