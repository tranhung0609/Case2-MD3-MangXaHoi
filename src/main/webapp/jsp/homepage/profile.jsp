<%--
  Created by IntelliJ IDEA.
  User: ACER
  Date: 6/5/2022
  Time: 9:41 AM
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
    <title>FakeBook</title>
    <script src="https://kit.fontawesome.com/ef7e2b893b.js" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/css/all.min.css"/>
    <script src="../../js/profile.js"></script>

</head>

<body>
<nav class="navbar">
    <div class="nav-left">
        <a href="#"><img class="logo" src="../../image/logofakebook.jpg"></a>
        <!--            <img class="logo" src="../../image/logofakebook.jpg">-->
        <ul class="navlogo">
            <li><a href="#"><img src="images/notification.png"></a></li>
            <li><a href="#"><img src="images/inbox.png"></a></li>
            <li><a href="#"><img src="images/video.png"></a></li>
        </ul>
    </div>
    <div class="nav-right">
        <div class="search-box">
            <img src="images/search.png" alt="">
            <input type="text" placeholder="Search">
        </div>
        <div class="profile-image online" onclick="UserSettingToggle()">
            <img src="images/profile-pic.png" alt="">
        </div>

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
        <!--            <div class="user-profile">-->
        <!--                <img src="images/feedback.png" alt="">-->
        <!--                <div>-->
        <!--                    <p> Give Feedback</p>-->
        <!--                    <a href="#">Help us to improve</a>-->
        <!--                </div>-->
        <!--            </div>-->
        <hr>
        <div class="settings-links">
            <img src="images/setting.png" alt="" class="settings-icon">
            <a href="#">Settings <img src="images/arrow.png" alt=""></a>
        </div>

        <!--            <div class="settings-links">-->
        <!--                <img src="images/help.png" alt="" class="settings-icon">-->
        <!--                <a href="#">Help & Support <img src="images/arrow.png" alt=""></a>-->
        <!--            </div>-->

        <!--            <div class="settings-links">-->
        <!--                <img src="images/Display.png" alt="" class="settings-icon">-->
        <!--                <a href="#">Display & Accessibility <img src="images/arrow.png" alt=""></a>-->
        <!--            </div>-->
        <!--TRUYỀN ĐƯỜNG LINK ĐỂ ĐI RA TRANG ĐĂNG NHẬP-->
        <div class="settings-links">
            <img src="images/logout.png" alt="" class="settings-icon">
            <a href="#">Logout <img src="images/arrow.png" alt=""></a>
        </div>

    </div>
</nav>

<!-- profile-page-------------------------- -->


<div class="profile-container">
    <img src="images/cover.png" class="coverImage" alt="">
    <div class="dashboard">
        <div class="left-dashboard">
            <img src="images/profile.png" class="dashboard-img" alt="">
            <div class="left-dashboard-info">
                <h3>Jack Nichoson</h3>
                <p>120 Friends - 20 mutuals</p>
                <div class="mutual-friend-images">
                    <img src="images/member-1.png" alt="">
                    <img src="images/member-2.png" alt="">
                    <img src="images/member-3.png" alt="">
                    <img src="images/member-5.png" alt="">
                </div>
            </div>
        </div>
        <div class="right-dashboard-info">
            <div class="right-dashboard-info-top">
                <button onclick="addFriend()" type="button"><i id="addThumb" class="fas fa-user-plus"></i> Friends
                </button>
                <button type="button" style="background-color: #f0f0f0; color: #0a0a0a"><i class="far fa-envelope"></i>
                    messages
                </button>
            </div>
            <div class="right-div-single-logo"><a href="#"> <i class="fas fa-ellipsis-h"></i></a></div>
        </div>
    </div>


    <div class="container content-profile-container">
        <div class="left-sidebar profile-left-sidebar">
            <div class="left-profile-sidebar-top">
                <div class="intro-bio">
                    <h4>Intro</h4>
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
                        <img src="images/photo1.png" alt="">
                        <img src="images/photo2.png" alt="">
                        <img src="images/photo3.png" alt="">

                        <img src="images/photo4.png" alt="">
                        <img src="images/photo5.png" alt="">
                        <img src="images/photo6.png" alt="">
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
                        <div class="first-friend">
                            <img src="images/member-1.png" alt="">
                            <p>Nathan M</p>
                        </div>
                        <div class="second-friend">
                            <img src="images/member-2.png" alt="">
                            <p>Joseph N</p>
                        </div>
                        <div class="third-friend">
                            <img src="images/member-3.png" alt="">
                            <p>Blondie K</p>
                        </div>
                        <div class="forth-friend">
                            <img src="images/member-4.png" alt="">
                            <p>Jonathon J</p>
                        </div>
                        <div class="fifth-friend">
                            <img src="images/member-5.png" alt="">
                            <p>Mark K</p>
                        </div>
                        <div class="sixth-friend">
                            <img src="images/member-6.png" alt="">
                            <p>Emilia M</p>
                        </div>
                        <div class="seventh-friend">
                            <img src="images/member-7.png" alt="">
                            <p>Max P</p>
                        </div>
                        <div class="eighth-friend">
                            <img src="images/member-8.png" alt="">
                            <p>Layla M</p>
                        </div>
                        <div class="ninth-friend">
                            <img src="images/member-9.png" alt="">
                            <p>Edward M</p>
                        </div>
                    </div>
                </div>
            </div>

        </div>

        <!-- main-content------- -->

        <div class="content-area profile-content-area">
            <div class="write-post-container">
                <div class="user-profile">
                    <img src="images/profile-pic.png" alt="">
                    <div>
                        <p> Alex Carry</p>
                        <!--                            <small>Public <i class="fas fa-caret-down"></i></small>-->
                    </div>
                </div>

                <div class="post-upload-textarea">
                    <textarea name="" placeholder="Bạn đang nghĩ gì ? " id="" cols="30" rows="3"></textarea>
                    <div class="add-post-links">
                        <a href="#" style="width: 30px;">Post</a>
                        <a href="#"><img src="images/live-video.png" alt="">Live Video</a>
                        <a href="#"><img src="images/photo.png" alt="">Photo/Video</a>
                        <a href="#"><img src="images/feeling.png" alt="">Feeling Activity</a>
                    </div>
                </div>
            </div>

            <div class="status-field-container write-post-container">
                <div class="user-profile-box">
                    <div class="user-profile">
                        <img src="images/profile-pic.png" alt="">
                        <div>
                            <p> Alex Carry</p>
                            <small>August 13 1999, 09.18 pm</small>
                        </div>
                    </div>
                    <div>
                        <a href="#"><i class="fas fa-ellipsis-v"></i></a>
                    </div>
                </div>
                <div class="status-field">
                    <p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Corporis dolores praesentium dicta
                        laborum nihil accusantium odit laboriosam, sed sit autem! <a
                                href="#">#This_Post_is_Better!!!!</a>
                    </p>
                    <img src="images/feed-image-1.png" alt="">

                </div>
                <div class="post-reaction">
                    <div class="activity-icons">
                        <div>
                            <form action="" id="like-post">
                                <button onclick="likePost()" id="like-btn"><i id="likeThumb"
                                                                              class="fa-regular fa-thumbs-up"></i>
                                </button>
                            </form>
                        </div>
                        <div>
                            <form action="" id="comment-post">
                                <button onclick="commentPost()" id="comment-btn"><i class="fa-regular fa-comment"></i>
                                </button>
                            </form>
                        </div>
                        <!--                            <div><img src="images/share.png" alt="">35</div>-->
                    </div>
                    <div class="post-profile-picture">
                        <img src="images/profile-pic.png " alt=""> <i class=" fas fa-caret-down"></i>
                    </div>
                </div>
            </div>
            <div class="status-field-container write-post-container">
                <div class="user-profile-box">
                    <div class="user-profile">
                        <img src="images/profile-pic.png" alt="">
                        <div>
                            <p> Alex Carry</p>
                            <small>August 13 1999, 09.18 pm</small>
                        </div>
                    </div>
                    <div>
                        <a href="#"><i class="fas fa-ellipsis-v"></i></a>
                    </div>
                </div>
                <div class="status-field">
                    <p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Corporis dolores praesentium dicta
                        laborum nihil accusantium odit laboriosam, sed sit autem! <a
                                href="#">#This_Post_is_Bigger!!!!</a>
                    </p>
                    <img src="images/feed-image-2.png" alt="">

                </div>
                <div class="post-reaction">
                    <div class="activity-icons">
                        <div><img src="images/like-blue.png" alt="">120</div>
                        <div><img src="images/comments.png" alt="">52</div>
                        <div><img src="images/share.png" alt="">35</div>
                    </div>
                    <div class="post-profile-picture">
                        <img src="images/profile-pic.png " alt=""> <i class=" fas fa-caret-down"></i>
                    </div>
                </div>
            </div>
            <div class="status-field-container write-post-container">
                <div class="user-profile-box">
                    <div class="user-profile">
                        <img src="images/profile-pic.png" alt="">
                        <div>
                            <p> Alex Carry</p>
                            <small>August 13 1999, 09.18 pm</small>
                        </div>
                    </div>
                    <div>
                        <a href="#"><i class="fas fa-ellipsis-v"></i></a>
                    </div>
                </div>
                <div class="status-field">
                    <p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Corporis dolores praesentium dicta
                        laborum nihil accusantium odit laboriosam, sed sit autem! <a
                                href="#">#This_Post_is_faster!!!!</a>
                    </p>
                    <img src="images/feed-image-3.png" alt="">

                </div>
                <div class="post-reaction">
                    <div class="activity-icons">
                        <div><img src="images/like-blue.png" alt="">120</div>
                        <div><img src="images/comments.png" alt="">52</div>
                        <div><img src="images/share.png" alt="">35</div>
                    </div>
                    <div class="post-profile-picture">
                        <img src="images/profile-pic.png " alt=""> <i class=" fas fa-caret-down"></i>
                    </div>
                </div>
            </div>
            <div class="status-field-container write-post-container">
                <div class="user-profile-box">
                    <div class="user-profile">
                        <img src="images/profile-pic.png" alt="">
                        <div>
                            <p> Alex Carry</p>
                            <small>August 13 1999, 09.18 pm</small>
                        </div>
                    </div>
                    <div>
                        <a href="#"><i class="fas fa-ellipsis-v"></i></a>
                    </div>
                </div>
                <div class="status-field">
                    <p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Corporis dolores praesentium dicta
                        laborum nihil accusantium odit laboriosam, sed sit autem! <a
                                href="#">#This_Post_is_perfect!!!!</a>
                    </p>
                    <img src="images/feed-image-4.png" alt="">

                </div>
                <div class="post-reaction">
                    <div class="activity-icons">
                        <div><img src="images/like-blue.png" alt="">120</div>
                        <div><img src="images/comments.png" alt="">52</div>
                        <div><img src="images/share.png" alt="">35</div>
                    </div>
                    <div class="post-profile-picture">
                        <img src="images/profile-pic.png " alt=""> <i class=" fas fa-caret-down"></i>
                    </div>
                </div>
            </div>
            <button type="button" class="btn-LoadMore" onclick="LoadMoreToggle()">Load More</button>
        </div>
    </div>
</div>
<footer id="footer">
    <p>&copy; Copyright 2021 - Socialbook All Rights Reserved</p>
</footer>
<script src="../../js/homepage.js"></script>
</body>

</html>
