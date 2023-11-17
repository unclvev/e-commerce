<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    </head>

    <body>

        <jsp:include page="Menu.jsp"></jsp:include>

            <!-- Start Banner Area -->
            <section class="banner-area organic-breadcrumb">
                <div class="container">
                    <div class="breadcrumb-banner d-flex flex-wrap align-items-center justify-content-end">
                        <div class="col-first">
                            <h1>Shopping Cart</h1>
                            <nav class="d-flex align-items-center">
                                <a href="index.html">Home<span class="lnr lnr-arrow-right"></span></a>
                                <a href="category.html">Cart</a>
                            </nav>
                        </div>
                    </div>
                </div>
            </section>
            <!-- End Banner Area -->

            <!--================Cart Area =================-->

            <section class="cart_area">
                <div class="container">
                    <div class="cart_inner">
                        <div class="table-responsive">
                            <table class="table">
                                <thead>
                                    <tr>
                                        <th scope="col">Product</th>
                                        <th scope="col">Price</th>
                                        <th scope="col">Quantity</th>
                                        <th scope="col">Total</th>
                                    </tr>
                                </thead>
                                <tbody>
                                <c:set var="o" value="${requestScope.cart}"/>
                                <c:forEach items="${o.items}" var="p">
                                    <tr>
                                        <td>
                                            <div class="media">
                                                <div class="d-flex">
<!--                                                    <img src="${p.product.image}" alt="">-->
                                                </div>
                                                <div class="media-body">
                                                    <p>${p.product.name}</p>
                                                </div>
                                            </div>
                                        </td>
                                        <td>
                                            <h5>${p.price}</h5>
                                        </td>
                                        <td>
                                            <div class="product_count">
                                                <input  type="text" name="num" value="${p.quantity}" id="sst" title="${p.quantity}" class="input-text qty">
                                                <button class="increase items-count" type="button">
                                                    <a href="process?num=1&id=${p.product.id}">
                                                        <i class="lnr lnr-chevron-up"></i>
                                                    </a>
                                                </button>
                                                <button class="reduced items-count" type="button">
                                                    <a href="process?num=-1&id=${p.product.id}">
                                                        <i class="lnr lnr-chevron-down"></i>
                                                    </a>
                                                </button>
                                            </div>

                                        </td>
                                        <td>
                                            <!<!-- total -->   <h5>${(p.price*p.quantity)}</h5>

                                            <form action="process" method="post">
                                                <input type="hidden" name="id" value="${p.product.id}"/>
                                                <input type="submit" value="Remove item"/>   
                                            </form>

                                        </td>
                                    </tr>
                                </c:forEach>


                                <tr>
                                    <td>

                                    </td>
                                    <td>

                                    </td>
                                    <td>
                                        <h5>Subtotal</h5>
                                    </td>
                                    <td>
                                        <h5>${o.totalMoney}</h5>
                                    </td>
                                </tr>
                                
                                <tr class="out_button_area">
                                    <td>

                                    </td>
                                    <td>

                                    </td>
                                    <td>

                                    </td>
                                    <td>
                                        <div class="checkout_btn_inner d-flex align-items-center">
                                            <a class="gray_btn" href="category">Continue Shopping</a>                                            
                                            <form id="checkoutForm" action="check" method="post">
                                                <a href="#" class="primary-btn" onclick="submitForm()">Check out</a>
                                            </form>
                                        </div>

                                    </td>
                                </tr>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </section>

        <!--================End Cart Area =================-->

        <jsp:include page="footer.jsp"></jsp:include>
        <script>
            function submitForm() {
                var form = document.getElementById("checkoutForm");
                form.action = "check";
                form.submit();
            }
        </script>
        <script>
            // L?y t?t c? các ph?n t? input s? l??ng
            const quantityInputs = document.querySelectorAll('.quantity-input');

            // X? lý s? ki?n khi ng??i dùng nh?p vào nút t?ng/gi?m
            quantityInputs.forEach(input => {
                const increaseButton = input.nextElementSibling.querySelector('.increase');
                const decreaseButton = input.nextElementSibling.nextElementSibling.querySelector('.reduced');

                increaseButton.addEventListener('click', () => {
                    const currentValue = parseInt(input.value);
                    input.value = currentValue + 1;
                });

                decreaseButton.addEventListener('click', () => {
                    const currentValue = parseInt(input.value);
                    if (currentValue > 1) {
                        input.value = currentValue - 1;
                    }
                });
            });
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