<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="model.Product" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html lang="zxx" class="no-js">

    <head>
        <!-- Mobile Specific Meta -->
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <!-- Favicon-->
        <link rel="shortcut icon" href="img/fav.png">
        <!-- Author Meta -->
        <meta name="author" content="CodePixar">
        <!-- Meta Description -->
        <meta name="description" content="">
        <!-- Meta Keyword -->
        <meta name="keywords" content="">
        <!-- meta character set -->
        <meta charset="UTF-8">
        <!-- Site Title -->
        <title>Karma Shop</title>

        <!--
            CSS
            ============================================= -->

        <link rel="stylesheet" href="css/linearicons.css">
        <link rel="stylesheet" href="css/owl.carousel.css">
        <link rel="stylesheet" href="css/font-awesome.min.css">
        <link rel="stylesheet" href="css/themify-icons.css">
        <link rel="stylesheet" href="css/nice-select.css">
        <link rel="stylesheet" href="css/nouislider.min.css">
        <link rel="stylesheet" href="css/bootstrap.css">
        <link rel="stylesheet" href="css/main.css">
        <style>
            .prd-bottom {
                display: flex;
            }

        </style>
    </head>

    <body id="category">

        <jsp:include page="Menu.jsp"></jsp:include>

            <!-- Start Banner Area -->
            <section class="banner-area organic-breadcrumb">
                <div class="container">
                    <div class="breadcrumb-banner d-flex flex-wrap align-items-center justify-content-end">
                        <div class="col-first">
                            <h1>Shop Category page</h1>
                            <nav class="d-flex align-items-center">
                                <a href="home">Home<span class="lnr lnr-arrow-right"></span></a>
                                <a href="#">Shop<span class="lnr lnr-arrow-right"></span></a>
                                <a href="category">Fashon Category</a>
                            </nav>
                        </div>
                    </div>
                </div>
            </section>
            <!-- End Banner Area -->
            <div class="container">
                <div class="row">
                    <div class="col-xl-3 col-lg-4 col-md-5">
                        <div class="sidebar-categories">

                            <div class="head">Browse Categories</div>
                            <ul class="main-categories">

                                <li class="main-nav-list"><a data-toggle="collapse" href="#fruitsVegetable" aria-expanded="false" aria-controls="fruitsVegetable"><span

                                            class="lnr lnr-arrow-right"></span>BRANDS<span class="number">(5)</span></a>

                                <c:forEach items="${listC}" var="o"> 
                                <li class="main-nav-list child active">
                                    <a href="categories?cid=${o.cid}">${o.cname}<span class="number"></span>
                                    </a>
                                </li>
                            </c:forEach>
                        </ul>                                 

                        </ul>
                    </div>
                    <!-- tìm theo cate --> 
                    <div class="sidebar-categories">
                        <div class="head">Browse Categories</div>
                        <ul class="main-categories">
                         
                            <form id="f1" action="category" method = "post">
                                <input type="hidden" name="go" value="category-checkbox">
                                <input type="checkbox" id="0" name="0" 
                                       ${cb[0]?"checked":""}                            
                                       value="0" onclick="setCheck2(this)"/>All<br>
                                <c:forEach items="${listC}" var="o"> 
                                    <label for="${o.cid}">${o.cname}</label>
                                    <input onclick="setCheck2(this)" type="checkbox" id="${o.cid}" name="${o.cid}" value="${o.cid}" <c:if test="${o.checked}">checked</c:if>>
                                        <br>
                                </c:forEach>
                            </form>                        
                        </ul>
                    </div>
                    <!<!-- tìm theo price --> 
                    <div class="sidebar-categories">   
                        <div class="head">Browse Categories</div>
                        <ul class="main-categories">
                            
                            <form id="f2" action="category" method = "post">
                                <input type="hidden" name="gos" value="category-checkbox">
                                <input type="checkbox" id="g0" name="1" 
                                       ${pb[0]?"checked":""}                            
                                       value="1 onclick="setCheck1(this)"/>All price<br/>
                                <c:forEach begin="0" end="${4}"  var="i">
                                    <input type="checkbox" id="g1" name="price" 
                                           ${pb[i+1]?"checked":""}
                                           value="${(i+1)}" onclick="setCheck1(this)"/>${pp[i]}<br/>
                                </c:forEach>                 
                            </form>
                        </ul>
                    </div>
                </div>
                <div class="col-xl-9 col-lg-8 col-md-7">
                    <!-- Start Filter Bar -->
                    <div class="filter-bar d-flex flex-wrap align-items-center">
                        <div class="sorting">
                            <select id="sortingSelect" onchange="handleSortingChange()">
                                <option value="default">Default sorting</option>
                                <option value="priceAsc">High to Low</option>
                                <option value="priceDesc">Low to high</option>
                            </select>
                        </div>

                    </div>
                    <!-- End Filter Bar -->
                    <!-- Start Best Seller -->
                    <form name="f" action="" method="post">
                        <section class="lattest-product-area pb-40 category-list">
                            <div class="row">
                                <c:forEach items ="${requestScope.data}" var="o">
                                    <c:set var="formId" value="'addToBagForm' + ${status.index}" />
                                    <c:set var="linkId" value="'addToBagLink' + ${status.index}" />
                                    <div class="col-lg-4 col-md-6">
                                        <div class="single-product">
                                            <img class="img-fluid" src="${o.image}" alt="">
                                            <div class="product-details">
                                                <h6>${o.name}</h6>
                                                <div class="price">
                                                    <h6>${o.price}$</h6>
                                                    <!--                                                <h6 class="l-through">$210.00</h6>-->
                                                </div>
                                                <div class="prd-bottom">

                                                    <form id="addToBagForm" action="buy" method="post" onsubmit="return buyItem()">
                                                        <input type="hidden" name="id" value="${o.id}">
                                                        <input type="hidden" name="num" value="1">
                                                        <a href="#" class="social-info" onclick="document.getElementById('addToBagForm').submit()">
                                                            <span class="ti-bag"></span>
                                                            <p class="hover-text">add to bag</p>
                                                        </a>
                                                        <button type="submit" style="display: none;"></button>
                                                    </form>

                                                    <a href="detail?pid=${o.id}" class="social-info">
                                                        <span class="lnr lnr-move"></span>
                                                        <p class="hover-text">view more</p>
                                                    </a>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </c:forEach>
                            </div>
                        </section>
                    </form>
                    <!-- End Best Seller -->
                    <!-- Start Filter Bar -->
                    <div class="filter-bar d-flex flex-wrap align-items-center">

                    </div>
                    <!-- End Filter Bar -->
                </div>
            </div>
        </div>

        <jsp:include page="footer.jsp"></jsp:include>

        <script type="text/javascript">
            function buyItem(productId) {
                var id = document.getElementById('addToBagForm').querySelector('input[name="id_' + productId + '"]').value;
                document.getElementById('addToBagForm').setAttribute("action", "buy?id=" + id + "&num=1");
                return true;
            }
        </script>
        <script type="text/javascript">
            function setCheck1(obj) {
                var fries = document.getElementsByName('price');
                if ((obj.id === 'g0') && (fries[0].checked === true))
                {
                    for (var i = 1; i < fries.length; i++)
                        fries[i].checked = false;
                } else {
                    for (var i = 1; i < fries.length; i++) {
                        if (fries[i].checked === true) {
                            fries[0].checked = false;
                            break;
                        }
                    }
                }
                document.getElementById('f2').submit();
            }
            function setCheck2(obj) {
                var fries = document.getElementsByName('cate');
                if ((obj.id === 'c0') && (fries[0].checked === true))
                {
                    for (var i = 1; i < fries.length; i++)
                        fries[i].checked = false;
                } else {
                    for (var i = 1; i < fries.length; i++) {
                        if (fries[i].checked === true) {
                            fries[0].checked = false;
                            break;
                        }
                    }
                }
                document.getElementById('f1').submit();
            }
        </script>






        <script src="js/vendor/jquery-2.2.4.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.11.0/umd/popper.min.js" integrity="sha384-b/U6ypiBEHpOf/4+1nzFpr53nxSS+GLCkfwBdFNTxtclqqenISfwAzpKaMNFNmj4"
        crossorigin="anonymous"></script>
        <script src="js/vendor/bootstrap.min.js"></script>
        <script src="js/jquery.ajaxchimp.min.js"></script>
        <script src="js/jquery.nice-select.min.js"></script>
        <script src="js/jquery.sticky.js"></script>
        <script src="js/nouislider.min.js"></script>
        <script src="js/jquery.magnific-popup.min.js"></script>
        <script src="js/owl.carousel.min.js"></script>
        <!--gmaps Js-->
        <script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyCjCGmQ0Uq4exrzdcL6rvxywDDOvfAu6eE"></script>
        <script src="js/gmaps.min.js"></script>
        <script src="js/main.js"></script>
    </body>

</html>