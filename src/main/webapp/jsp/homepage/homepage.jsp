<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>FakeBook</title>
    <script src="https://kit.fontawesome.com/ef7e2b893b.js" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="../../css/homepage.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/css/all.min.css"/>
</head>

<body>
<nav class="navbar">
    <div class="nav-left"><img class="logo" src="../../image/logofakebook.jpg" alt="">
        <ul class="navlogo">
            <li><img src="images/notification.png"></li>
            <li><img src="images/inbox.png"></li>
            <li><img src="images/video.png"></li>
        </ul>
    </div>
    <div class="nav-right">
        <div class="search-box">
            <img src="images/search.png" alt="">
            <a href="/users?action=search"><input type="search" placeholder="Search1"></a>
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
                    <a href="users?action=profile&id=${user.id}">See your profile</a>
                </div>
            </div>
            <div id="dark-button" onclick="darkModeON()">
                <span></span>
            </div>
        </div>
        <hr>
        <!--        <div class="user-profile">-->
        <!--            <img src="images/feedback.png" alt="">-->
        <!--            <div>-->
        <!--                <p> Give Feedback</p>-->
        <!--                <a href="#">Help us to improve</a>-->
        <!--            </div>-->
        <!--        </div>-->
        <hr>
        <div class="settings-links">
            <img src="images/setting.png" alt="" class="settings-icon">
            <a href="/users?action=edit&id=${user.id}">Settings Profile <img src="images/arrow.png" alt=""></a>
        </div>

        <!--        <div class="settings-links">-->
        <!--            <img src="images/help.png" alt="" class="settings-icon">-->
        <!--            <a href="#">Help & Support <img src="images/arrow.png" alt=""></a>-->
        <!--        </div>-->

        <!--        <div class="settings-links">-->
        <!--            <img src="images/Display.png" alt="" class="settings-icon">-->
        <!--            <a href="#">Display & Accessibility <img src="images/arrow.png" alt=""></a>-->
        <!--        </div>-->
        <!--Nhập đường truyền vào phần đăng nhập-->
        <div class="settings-links">
            <img src="images/logout.png" alt="" class="settings-icon">
            <a href="/users">Logout <img src="images/arrow.png" alt=""></a>
        </div>

    </div>
</nav>

<!-- content-area------------ -->

<div class="container">
    <div class="left-sidebar">
        <div class="important-links">
            <!--            <a href="#"><img src="images/news.png" alt="">Latest News</a>-->
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
                <!--                <img src="/video/r15mv3.mp4" onclick="" class="#videos-story">-->
                <!--                <img onclick="" src="/video/r15mv3.mp4" class="img-story" alt="">-->
                <video onclick="" class="video-story" controls>
                    <source src="../../video/r15mv3.mp4" type="video/mp4">
                </video>
                <img src="../../image/anhson.jpg" alt="">
                <!--                    <video></video>-->
                <p>Sơn Bóng Bẩy</p>
            </div>
            <div class="story story3">
                <video onclick="" class="video-story" controls>
                    <source src="../../video/5000ty.mp4" type="video/mp4">
                </video>
                <img src="../../image/anhnam.jpg" alt="">
                <p>Nam Đất Đai</p>
            </div>
            <div class="story story4">
                <video onclick="" class="video-story" controls>
                    <source src="../../video/tuyetvoi.mp4" type="video/mp4">
                </video>
                <img src="../../image/anhdat.jpg" alt="">
                <p>Đạt Một Lít</p>
            </div>
            <div class="story story5"><video onclick="" class="video-story" controls id="videos">
                <source src="../../video/r1.mp4" type="video/mp4">
            </video>
                <img src="../../image/tuệ%20đĩ.jpg" alt="">
                <p>Thích Hương Tuệ</p>
            </div>
        </div>

        <div class="write-post-container">
            <div class="user-profile">
                <img src="images/profile-pic.png" alt="">
                <div>
                    <p> Alex Carry</p>
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
                            href="#">#This_Post_is_Better!!!!</a></p>
                <img src="images/feed-image-1.png" alt="">

            </div>
            <div class="post-reaction">
                <div class="activity-icons">
                    <!--                    <div>-->
                    <!--                        <a href="#">-->
                    <!--                            <button></button>-->
                    <!--                        </a>-->
                    <!--                    </div>-->
                    <div>
                        <form action="" id="like-post">
                            <button onclick="likePost()" id="like-btn"><i id="likeThumb" class="fa-regular fa-thumbs-up"></i></button>
                        </form>
                    </div>

                    <!--                    <div>-->
                    <!--                        <a href="">-->
                    <!--                            <img src="images/comments.png">-->
                    <!--                        </a>-->
                    <!--                    </div>-->
                    <div>
                        <form action="" id="comment-post">
                            <button onclick="commentPost()" id="comment-btn"><i class="fa-regular fa-comment"></i></button>
                        </form>
                    </div>

                    <!--                    <div>-->
                    <!--                        <a href="">-->
                    <!--                            <img src="images/share.png">-->
                    <!--                        </a>-->
                    <!--                    </div>-->
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
                            href="#">#This_Post_is_Bigger!!!!</a></p>
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
                            href="#">#This_Post_is_faster!!!!</a></p>
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
                            href="#">#This_Post_is_perfect!!!!</a></p>
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

        <div class="online-list">
            <div class="online">
                <img src="images/member-1.png" alt="">
            </div>
            <p>Alison Mina</p>
        </div>

        <div class="online-list">
            <div class="online">
                <img src="images/member-2.png" alt="">
            </div>
            <p>Jackson Aston</p>
        </div>
        <div class="online-list">
            <div class="online">
                <img src="images/member-3.png" alt="">
            </div>
            <p>Samona Rose</p>
        </div>
    </div>
</div>
<footer id="footer">
    <p>&copy; Copyright 2021 - Socialbook All Rights Reserved</p>
</footer>
<script src="../../js/homepage.js"></script>
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
<script>
    onmouseover="function play() {document.getElementById('videos').play(); } play()"
    onmouseout="function stop(){document.getElementById('videos').pause();} stop()"
</script>
</body>
</html>