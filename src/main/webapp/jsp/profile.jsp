<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: hongh
  Date: 02/06/2022
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
    <link rel="stylesheet" href="../css/homepage.css">
    <title>Profile - Social Book</title>
    <script src="https://kit.fontawesome.com/ef7e2b893b.js" crossorigin="anonymous"></script>
</head>
<style>
    a {
        text-decoration: none!important;
        color: #0a0a0a;
    }
</style>
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
            <%--            <li><img src="images/notification.png"></li>--%>
            <%--            <li><img src="images/inbox.png"></li>--%>
            <%--            <li><img src="images/video.png"></li>--%>
        </ul>
    </div>
    <div class="nav-right">
        <div class="search-box">
            <img src="jsp/homepage/images/search.png" alt="">
            <input type="text" placeholder="Search">
        </div>
        <div class="profile-image online" onclick="UserSettingToggle()">
            <img src="${currentUser.avatar}" alt="">
        </div>

    </div>
    <div class="user-settings">
        <div class="profile-darkButton">
            <div class="user-profile">
                <img src="${currentUser.avatar}" alt="">
                <div>
                    <p> ${currentUser.fullName}</p>
                    <a href="#">See your profile</a>
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
            <a href="jsp/login-register/login.jsp">Logout <img src="jsp/homepage/images/arrow.png" alt=""></a>
        </div>

    </div>
</nav>

<!-- profile-page-------------------------- -->


<div class="profile-container">
    <img src="jsp/homepage/images/cover.png" class="coverImage" alt="">
    <div class="dashboard">
        <div class="left-dashboard">
            <img src="${user.avatar}" class="dashboard-img" alt="avt">
            <div class="left-dashboard-info">
                <h3>${user.fullName}</h3>
                <p>${friends.size()} friends - ${mutualFriends.size()} mutuals</p>
                <div class="mutual-friend-images">
                    <div class="first-friend">
                        <c:forEach items="${friends}" var="friend">
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
                <form action="/users" method="post">
                    <input type="hidden" name="action" value="send-invitation">
                    <input type="hidden" name="id" value="${user.id}">
                    <c:if test="${relationship == 0}">
                    <button><i class="fas fa-user-plus"></i> Friends</button>
                    </c:if>
                    <c:if test="${relationship == 1}">
                        <button><i class="fas fa-user-plus"></i> Unfriend</button>
                    </c:if>
                    <c:if test="${relationship == 2}">
                        <button><i class="fas fa-user-plus"></i> Sending</button>
                    </c:if>
                </form>
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
                        <p>Studied bsc at Choumuhoni Collage</p>
                    </a>
                    <a href="#"><i class="fas fa-user-graduate"></i>
                        <p>Went to Technical School & Collage</p>
                    </a>
                    <a href="#"><i class="fas fa-home"></i>
                        <p>Lives in Noakhali, Chittagong</p>
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
                        <c:forEach items="${friends}" var="friend">
                            <div class="first-friend">
                                <img src="${friend.avatar}" alt="avt">
                                <p><a href="/users?action=profile&id=${friend.id}">${friend.fullName}</a></p>
                            </div>
                        </c:forEach>
                    </div>
                </div>
            </div>
            <div class="left-profile-sidebar-top gallery">
                <div class="heading-link profile-heading-link">
                    <h4>Friends</h4>
                    <a href="">Mutual Friends</a>
                </div>

                <div class="gallery-photos">
                    <div class="gallery-photos-rowFirst">
                        <c:forEach items="${mutualFriends}" var="friend">
                            <div class="first-friend">
                                <img src="${friend.avatar}" alt="avt">
                                <p><a href="/users?action=profile&id=${friend.id}">${friend.fullName}</a></p>
                            </div>
                        </c:forEach>
                    </div>
                </div>
            </div>

        </div>

        <!-- main-content------- -->

        <div class="content-area profile-content-area">
<%--            <div class="write-post-container">--%>
<%--                <div class="user-profile">--%>
<%--                    <img src="${user.avatar}" alt="">--%>
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
            <div class="write-post-container">
                <form action="/posts" method="post">
                    <input type="hidden" value="add-post" name="action">
                    <input type="hidden" value="${currentUser.id}" name="userId">
                    <div class="user-profile">
                        <img src="${currentUser.avatar}" alt="">
                        <div>
                            <p> ${currentUser.fullName}</p>
                            <small>
                                <select name="viewModeId" class="form-control"
                                        aria-label="Default select example">
                                    <c:forEach items="${viewModes}" var="viewMode">
                                        <option value="${viewMode.id}">${viewMode.name}</option>
                                    </c:forEach>
                                </select>
                                <i class="fas fa-caret-down"></i>
                            </small>
                        </div>
                    </div>
                    <div class="post-upload-textarea">
                    <textarea name="content" placeholder="What's on your mind, ${currentUser.fullName}?" id="" cols="30"
                              rows="3"></textarea>
                        <div class="add-post-links">
                            <input type="text" name="image" placeholder="Insert your image">
                            <%--                        <a href="#"><img src="images/photo.png" alt="">Photo/Video</a>--%>
                            <button>Post</button>
                        </div>
                    </div>
                </form>
            </div>

            <c:forEach items="${publicPosts}" var="post">
                <div class="status-field-container write-post-container">
                    <div class="user-profile-box">
                        <div class="user-profile">
                            <img src="${post.getUser().getAvatar()}" alt="">
                            <div>
                                <p> ${post.getUser().getFullName()}</p>
                                <small>${post.time}</small>
                            </div>
                        </div>
                        <div>
                            <a href="#"><i class="fas fa-ellipsis-v"></i></a>
                        </div>
                    </div>
                    <div class="status-field">
                        <p>${post.content}</p>
                        <img src="${post.image}" alt="">
                    </div>
                    <div class="post-reaction">
                        <div class="activity-icons">
                            <div>
                                <form action="/posts" method="post">
                                    <input type="hidden" name="action" value="like">
                                    <input type="hidden" name="postId" value="${post.id}">
                                    <button>
                                        <img src="jsp/homepage/images/like.png" alt="">
                                    </button>
                                        ${post.likeCount} likes
                                </form>
                            </div>
                            <div><img src="jsp/homepage/images/comments.png" alt="">${post.commentCount} comments</div>
                            <div><img src="jsp/homepage/images/share.png" alt="">0</div>
                        </div>
                        <div class="post-profile-picture">
                            <img src="${currentUser.avatar}" alt=""> <i class=" fas fa-caret-down"></i>
                        </div>
                    </div>
                    <c:forEach items="${post.getComments()}" var="comment">
                        <div>
                            <div class="user-profile"><img src="${comment.getUser().getAvatar()}" alt="">
                                <div>
                                    <p> ${comment.getUser().getFullName()}</p>
                                    <small>${comment.time}</small>
                                </div>
                            </div>
                            <div class="status-field"><p>${comment.content}</p></div>
                        </div>
                    </c:forEach>
                    <form action="/posts" method="post">
                        <input type="hidden" name="action" value="comment">
                        <input type="hidden" name="postId" value="${post.id}">
                        <div class="post-upload-textarea">
                    <textarea name="commentContent" placeholder="Write a comment" cols="30"
                              rows="1"></textarea>
                            <button>Comment</button>
                        </div>
                    </form>

                </div>
            </c:forEach>
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
            <button type="button" class="btn-LoadMore" onclick="LoadMoreToggle()">Load More</button>
        </div>
    </div>
</div>
<footer id="footer">
    <p>&copy; Copyright 2021 - Socialbook All Rights Reserved</p>
</footer>
<script src="../js/homepage.js"></script>
</body>

</html>
