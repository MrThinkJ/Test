// Ajax
$(document).ready(function() {
    const url = window.location.href;
    const bookName = url.split("/")[5];
    $('.add-btn').click(function(event) {
        event.preventDefault();
        const formData = new FormData($("#add-form")[0]);
        // formData.append('file', $('#file')[0].files[0]);
        $.ajax({
            type: 'POST',
            url: `/nguoi-dang/novel/${bookName}/chapter/update/process`,
            data: formData,
            processData: false,
            contentType: false,
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

// Setting
const inputPrice = `<label>Giá chương:</label>
<div class="input">
    <input type="text" name="price" id="chapter-price" placeholder="Giá của chương">
</div>`;
const vip = document.querySelector("#vip");
const checkBox = document.querySelector(".check-box");
const form = document.querySelector("#add-form");
const checkBoxField = checkBox.parentNode;

vip.addEventListener("click", (event) => {
    const label = event.target.parentNode;
    if (!label.classList.contains("active")) {
        label.classList.add("active");
        const field = document.createElement("div");
        field.classList.add("field");
        field.classList.add("price-field");
        field.innerHTML = inputPrice;
        checkBoxField.insertAdjacentElement("afterend", field);
    } else {
        const chapterPrice =
            document.querySelector("#chapter-price").parentNode.parentNode;
        chapterPrice.classList.add("not-price");
        label.classList.add("not-active");
        label.classList.remove("active");
        setTimeout(() => {
            label.classList.remove("not-active");
        }, 200);
        setTimeout(() => {
            form.removeChild(chapterPrice);
        }, 100);
    }
});

// const input = document.querySelector(".inputfile");
// const label = document.querySelector(".fileLabel");
// input.addEventListener("change", function (e) {
//     const fileName = e.target.value.split("\\").pop();
//     if (fileName) label.innerHTML = fileName;
// });

