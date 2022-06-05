<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ACER
  Date: 6/2/2022
  Time: 8:59 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>FakeBook</title>
    <script src="https://kit.fontawesome.com/ef7e2b893b.js" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="../../css/homepage.css">
</head>

<body>
<nav class="navbar">
    <div class="nav-left"><a href="jsp/homepage/homepage.jsp"><img class="logo" src="../../image/logofakebook.jpg"
                                                                   alt=""></a>
        <ul class="navlogo">
            <p style="color: #0a0a0a"><a style="color: #0a0a0a"
                                         href="/users?action=my-profile&id=${currentUser.id}">${currentUser.fullName}</a>
            </p>
        </ul>
        <div class="profile-image online" onclick="UserSettingToggle()">
            <img src="${currentUser.avatar}" alt="myAvt">
        </div>
    </div>
    <div class="nav-right">
        <div class="search-box">
            <img src="images/search.png" alt="">
            <input type="text" placeholder="Search">
        </div>
        <%--        <div class="profile-image online" onclick="UserSettingToggle()">--%>
        <%--            <img src="images/profile-pic.png" alt="">--%>
        <%--        </div>--%>

    </div>
    <div class="user-settings">
        <div class="profile-darkButton">
            <div class="user-profile">
                <img src="images/profile-pic.png" alt="">
                <div>
                    <p> Alex Carry</p>
                    <a href="#">See your profile</a>
                </div>
            </div>
            <div id="dark-button" onclick="darkModeON()">
                <span></span>
            </div>
        </div>
        <hr>
        <div class="user-profile">
            <img src="images/feedback.png" alt="">
            <div>
                <p> Give Feedback</p>
                <a href="#">Help us to improve</a>
            </div>
        </div>
        <hr>
        <div class="settings-links">
            <img src="images/setting.png" alt="" class="settings-icon">
            <a href="#">Settings & Privary <img src="images/arrow.png" alt=""></a>
        </div>

        <div class="settings-links">
            <img src="images/help.png" alt="" class="settings-icon">
            <a href="#">Help & Support <img src="images/arrow.png" alt=""></a>
        </div>

        <div class="settings-links">
            <img src="images/Display.png" alt="" class="settings-icon">
            <a href="#">Display & Accessibility <img src="images/arrow.png" alt=""></a>
        </div>

        <div class="settings-links">
            <img src="images/logout.png" alt="" class="settings-icon">
            <a href="#">Logout <img src="images/arrow.png" alt=""></a>
        </div>

    </div>
</nav>

<!-- content-area------------ -->

<div class="container">
    <div class="left-sidebar">
        <div class="important-links">
            <a href="#"><img src="images/news.png" alt="">Latest News</a>
            <a href="#"><img src="images/friends.png" alt="">Friends</a>
            <!--                <a href="#"><img src="images/group.png" alt="">Groups</a>-->
            <!--                <a href="#"><img src="images/marketplace.png" alt="">marketplace</a>-->
            <a href="#"><img src="images/watch.png" alt="">Watch</a>
            <a href="#">See More</a>
        </div>

    </div>

    <!-- main-content------- -->

    <div class="content-area">
        <div class="story-gallery">
            <div class="story story1">
                <img class="add-story" src="images/upload.png" alt="">
                <p>Post Story</p>
            </div>
            <div class="story story2">
                <img src="../../image/anhson.jpg" alt="">
                <!--                    <video></video>-->
                <!--                    <iframe width="560" height="315" src="https://www.youtube.com/embed/Khz3jy6dzw0" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>-->

                <p>Sơn Bóng Bẩy</p>
            </div>
            <div class="story story3">
                <img src="../../image/anhnam.jpg" alt="">
                <p>Nam Đất Đai</p>
            </div>
            <div class="story story4">
                <img src="../../image/anhdat.jpg" alt="">
                <p>Đạt Một Lít</p>
            </div>
            <div class="story story5">
                <img src="../../image/tuệ%20đĩ.jpg" alt="">
                <p>Thích Hương Tuệ</p>
            </div>
        </div>
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

        <c:forEach items="${postsOfFriends}" var="post">
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
                        <div><img src="jsp/homepage/images/share.png" alt="">35</div>
                    </div>
                    <div class="post-profile-picture">
                        <img src="images/profile-pic.png " alt=""> <i class=" fas fa-caret-down"></i>
                    </div>
                </div>
                <form action="/posts" method="post">
                    <input type="hidden" name="action" value="comment">
                    <input type="hidden" name="postId" value="${post.id}">
                    <div class="post-upload-textarea">
                    <textarea name="commentContent" placeholder="Write a comment" cols="30"
                              rows="1"></textarea>
                            <button s>Comment</button>
                    </div>
                </form>
                <c:forEach items="${comments}" var="comment">
                    <div class="user-profile">
                        <img src="${comment.getUser().getAvatar()}" alt="">
                        <div>
                            <p> ${comment.getUser().getFullName()}</p>
                            <small>${comment.time}</small>
                        </div>
                        <div><p>${comment.content}</p></div>
                    </div>
                </c:forEach>
            </div>

        </c:forEach>
        <button type="button" class="btn-LoadMore" onclick="LoadMoreToggle()">Load More</button>
    </div>

    <!-- sidebar------------ -->
    <div class="right-sidebar">
        <!--            <div class="heading-link">-->
        <!--                <h4>Events</h4>-->
        <!--                <a href="">See All</a>-->
        <!--            </div>-->

        <!--            <div class="events">-->
        <!--                <div class="left-event">-->
        <!--                    <h4>13</h4>-->
        <!--                    <span>august</span>-->
        <!--                </div>-->
        <!--                <div class="right-event">-->
        <!--                    <h4>Social Media</h4>-->
        <!--                    <p> <i class="fas fa-map-marker-alt"></i> wisdom em Park</p>-->
        <!--                    <a href="#">More Info</a>-->
        <!--                </div>-->
        <!--            </div>-->
        <!--            <div class="events">-->
        <!--                <div class="left-event">-->
        <!--                    <h4>18</h4>-->
        <!--                    <span>January</span>-->
        <!--                </div>-->
        <!--                <div class="right-event">-->
        <!--                    <h4>Mobile Marketing</h4>-->
        <!--                    <p><i class="fas fa-map-marker-alt"></i> wisdom em Park</p>-->
        <!--                    <a href="#">More Info</a>-->
        <!--                </div>-->
        <!--            </div>-->

        <!--            <div class="heading-link">-->
        <!--                <h4>Advertisement</h4>-->
        <!--                <a href="">Close</a>-->
        <!--            </div>-->
        <!--            <div class="advertisement">-->
        <!--                <img src="images/advertisement.png" class="advertisement-image" alt="">-->
        <!--            </div>-->

        <!--            <div class="heading-link">-->
        <!--                <h4>Conversation</h4>-->
        <!--                <a href="">Hide Chat</a>-->
        <!--            </div>-->
        <div>
            <div class="heading-link profile-heading-link">
                <h4>Suggestions for making friends</h4>
            </div>
            <c:forEach items="${otherUsers}" var="user">
                <div class="online-list">
                    <div class="online">
                        <img src="${user.avatar}" alt="avt">
                    </div>
                    <p><a href="/users?action=profile&id=${user.id}">${user.fullName}</a></p>
                </div>
            </c:forEach>
        </div>
        <%--        <div class="online-list">--%>
        <%--            <div class="online">--%>
        <%--                <img src="images/member-2.png" alt="">--%>
        <%--            </div>--%>
        <%--            <p>Jackson Aston</p>--%>
        <%--        </div>--%>
        <%--        <div class="online-list">--%>
        <%--            <div class="online">--%>
        <%--                <img src="images/member-3.png" alt="">--%>
        <%--            </div>--%>
        <%--            <p>Samona Rose</p>--%>
        <%--        </div>--%>
        <div>
            <div class="heading-link profile-heading-link">
                <h4>Friend Request</h4>
            </div>
            <c:forEach items="${friendRequests}" var="user">
                <div class="online-list">
                    <div class="online">
                        <img src="${user.avatar}" alt="avt">
                    </div>
                    <p><a href="/users?action=profile&id=${user.id}">${user.fullName}</a></p>
                    <form action="/users?action=accept-request&id=${user.id}" method="post">
                        <button>Accept</button>
                    </form>
                    <form action="/users?action=delete-request&id=${user.id}" method="post">
                        <button>Cancel</button>
                    </form>
                </div>
            </c:forEach>
        </div>
    </div>
</div>
<footer id="footer">
    <p>&copy; Copyright 2021 - Socialbook All Rights Reserved</p>
</footer>
<script src="../../js/homepage.js"></script>
</body>
</html>
