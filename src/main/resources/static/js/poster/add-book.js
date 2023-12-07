const type = document.querySelectorAll(".type input");
type.forEach((item) => {
    item.addEventListener("click", (event)=>{
        const label = event.target.parentNode;
        if (!label.classList.contains('active')){
            label.classList.add("active");
        } else{
            label.classList.add("not-active");
            label.classList.remove("active");
            setTimeout(()=>{
                label.classList.remove("not-active")
            }, 200);
        }
    })
});

$(document).ready(function () {
    $(".add-btn").click(function (event) {
        event.preventDefault();
        const formData = $("#add-form").serialize();
        $.ajax({
            type: "POST",
            url: "/nguoi-dang/novel/add/process",
            data: formData,
            success: function (response) {
                if (response !== "success") {
                    const error = document.createElement("div");
                    error.innerText = response;
                    error.classList.add("error");
                    const noti = document.querySelector(".notification");
                    noti.appendChild(error);
                    setTimeout(() => {
                        error.classList.add("hide");
                    }, 2500);
                    setTimeout(() => {
                        noti.removeChild(error);
                    }, 3000);
                }
                else{
                    const success = document.createElement("div");
                    success.innerText = "Thành công";
                    success.classList.add("success");
                    const noti = document.querySelector(".notification");
                    noti.appendChild(success);
                    setTimeout(() => {
                        success.classList.add("hide");
                    }, 2500);
                    setTimeout(() => {
                        noti.removeChild(success);
                    }, 3000);
                    setTimeout(() => {
                        window.location.href = "/nguoi-dang";
                    }, 1000);
                }
            },
            error: function (xhr, status, error) {
                console.log(error);
            },
        });
    });
});
