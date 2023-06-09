const li = document.getElementById("btnSet");
const $listBtn = document.getElementById("listBtn");
const listName = []; // 최종 이름들이 담긴 리스트!!!!

function toggle() {
    if (li.style.display !== "none") {
        $profile.style.opacity = 1;
        $bt.style.opacity = 1;
        li.style.display = "none";
    } else {
        $profile.style.opacity = 0.4;
        $bt.style.opacity = 0.4;
        li.style.opacity = 1;
        li.style.display = "flex";
    }
}
$listBtn.addEventListener("click", toggle);

const IMG = [
    "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRmxmdxCmaF0aRGN4gUi2o3xueEigSn5F9ymA&usqp=CAU",
    "https://lifegym.co.kr/web/product/big/20200619/7b3f1145fbdbb10ac17baff858ddfc23.jpg",
    "https://cdn.011st.com/11dims/resize/600x600/quality/75/11src/product/5339020352/B.jpg?146000000",
    "https://cdn-pro-web-218-5.cdn-nhncommerce.com/bodyxtr0237_godomall_com/data/goods/21/07/27/3640/3640_detail_076.jpg",
    "https://gdimg.gmarket.co.kr/1561008695/still/600?ver=1610005421",
    "https://mblogthumb-phinf.pstatic.net/MjAyMjA4MTdfMjAx/MDAxNjYwNzMxNjkyNjAy.MteSkzplo9ET5qA8Y55rQzEcxkvG6Jcrbce1xczQDJYg.GT09uyz3HN7mRY5Vlx9a6wY2ZOKQCldvdV62iZdTmMAg.JPEG.nineonefitness/SE-582abee3-8c3e-403a-85ae-a2f4e914ecf3.jpg?type=w800",
    "https://www.lifefitness.co.uk/resource/image/1518452/portrait_ratio1x1/400/400/97f6c139b520030adc2741b0010019e1/VU/hammer-strength-select-lat-pulldown-image-1-.jpg",
    "https://openimage.interpark.com/goods_image_big/3/1/4/1/7736723141_l.jpg",
    "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRmxmdxCmaF0aRGN4gUi2o3xueEigSn5F9ymA&usqp=CAU",
    "https://lifegym.co.kr/web/product/big/20200619/7b3f1145fbdbb10ac17baff858ddfc23.jpg",
    "https://cdn.011st.com/11dims/resize/600x600/quality/75/11src/product/5339020352/B.jpg?146000000",
    "https://cdn-pro-web-218-5.cdn-nhncommerce.com/bodyxtr0237_godomall_com/data/goods/21/07/27/3640/3640_detail_076.jpg",
    "https://gdimg.gmarket.co.kr/1561008695/still/600?ver=1610005421",
    "https://mblogthumb-phinf.pstatic.net/MjAyMjA4MTdfMjAx/MDAxNjYwNzMxNjkyNjAy.MteSkzplo9ET5qA8Y55rQzEcxkvG6Jcrbce1xczQDJYg.GT09uyz3HN7mRY5Vlx9a6wY2ZOKQCldvdV62iZdTmMAg.JPEG.nineonefitness/SE-582abee3-8c3e-403a-85ae-a2f4e914ecf3.jpg?type=w800",
    "https://www.lifefitness.co.uk/resource/image/1518452/portrait_ratio1x1/400/400/97f6c139b520030adc2741b0010019e1/VU/hammer-strength-select-lat-pulldown-image-1-.jpg",
    "https://openimage.interpark.com/goods_image_big/3/1/4/1/7736723141_l.jpg",
    "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRmxmdxCmaF0aRGN4gUi2o3xueEigSn5F9ymA&usqp=CAU",
    "https://lifegym.co.kr/web/product/big/20200619/7b3f1145fbdbb10ac17baff858ddfc23.jpg",
    "https://cdn.011st.com/11dims/resize/600x600/quality/75/11src/product/5339020352/B.jpg?146000000",
    "https://cdn-pro-web-218-5.cdn-nhncommerce.com/bodyxtr0237_godomall_com/data/goods/21/07/27/3640/3640_detail_076.jpg",
    "https://gdimg.gmarket.co.kr/1561008695/still/600?ver=1610005421",
    "https://mblogthumb-phinf.pstatic.net/MjAyMjA4MTdfMjAx/MDAxNjYwNzMxNjkyNjAy.MteSkzplo9ET5qA8Y55rQzEcxkvG6Jcrbce1xczQDJYg.GT09uyz3HN7mRY5Vlx9a6wY2ZOKQCldvdV62iZdTmMAg.JPEG.nineonefitness/SE-582abee3-8c3e-403a-85ae-a2f4e914ecf3.jpg?type=w800",
    "https://www.lifefitness.co.uk/resource/image/1518452/portrait_ratio1x1/400/400/97f6c139b520030adc2741b0010019e1/VU/hammer-strength-select-lat-pulldown-image-1-.jpg",
    "https://openimage.interpark.com/goods_image_big/3/1/4/1/7736723141_l.jpg",
    "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRmxmdxCmaF0aRGN4gUi2o3xueEigSn5F9ymA&usqp=CAU",
    "https://lifegym.co.kr/web/product/big/20200619/7b3f1145fbdbb10ac17baff858ddfc23.jpg",
    "https://cdn.011st.com/11dims/resize/600x600/quality/75/11src/product/5339020352/B.jpg?146000000",
    "https://cdn-pro-web-218-5.cdn-nhncommerce.com/bodyxtr0237_godomall_com/data/goods/21/07/27/3640/3640_detail_076.jpg",
    "https://gdimg.gmarket.co.kr/1561008695/still/600?ver=1610005421",
    "https://mblogthumb-phinf.pstatic.net/MjAyMjA4MTdfMjAx/MDAxNjYwNzMxNjkyNjAy.MteSkzplo9ET5qA8Y55rQzEcxkvG6Jcrbce1xczQDJYg.GT09uyz3HN7mRY5Vlx9a6wY2ZOKQCldvdV62iZdTmMAg.JPEG.nineonefitness/SE-582abee3-8c3e-403a-85ae-a2f4e914ecf3.jpg?type=w800",
    "https://www.lifefitness.co.uk/resource/image/1518452/portrait_ratio1x1/400/400/97f6c139b520030adc2741b0010019e1/VU/hammer-strength-select-lat-pulldown-image-1-.jpg",
    "https://openimage.interpark.com/goods_image_big/3/1/4/1/7736723141_l.jpg",
];

const equipmentName = [
    "PullUpBar",
    "ShoulderPressMachine",
    "AssistPullUpMachine",
    "BenchPress",
    "SquatMachine",
    "BarbellRow",
    "LetPullDown",
    "PowerRack",
    "LegPressMachine",
    "HipAbduction",
    "MedicineBall",
    "HipAdduction",
    "PecDeckFlyMachine",
    "AbRoller",
    "CableTricepsExtensionMachine",
    "SideLateralMachine",
    "SeatedRowMachine",
    "CrunchMachine",
    "Stability Ball",
    "InclineBench",
    "DeclineBench",
    "Leg Curl Machine",
    "DipsMachine",
    "Leg Extension Machine",
    "ArmCurlMachine",
    "Chest Press Machine",
    "JumpRope",
    "RowingMachine",
    "Step Mill",
    "Cycle",
    "FoamRoller",
    "YogaMat",
];

const container = document.querySelector("#container");
for (let i = 0; i < IMG.length; i++) {
    const img = document.createElement("img");
    img.setAttribute("class", "eqp");
    img.setAttribute("src", IMG[i]);
    const data = document.createElement("span");
    data.textContent = equipmentName[i];

    const bigContainer = document.createElement("div");
    const imgContainer = document.createElement("div");
    const dataContainer = document.createElement("div");

    bigContainer.style.display = "flex";
    bigContainer.style.flexDirection = "row";
    bigContainer.style.alignItems = "center";
    dataContainer.style.fontSize = "20px";
    dataContainer.style.fontWeight = "550";

    dataContainer.appendChild(data);
    imgContainer.appendChild(img);
    bigContainer.append(imgContainer, dataContainer);
    container.appendChild(bigContainer);
    img.addEventListener("click", (e) => goCart(img, data));
}

const cart = document.querySelector("#cart");

function goCart(i, j) {
    cart.appendChild(i);
    cart.appendChild(j);
    const bigContainer = document.createElement("div");
    const imgContainer = document.createElement("div");
    const dataContainer = document.createElement("div");

    bigContainer.style.display = "flex";
    bigContainer.style.flexDirection = "column";
    bigContainer.style.alignItems = "center";
    bigContainer.style.fontSize = "15px";
    bigContainer.style.fontWeight = "550";

    dataContainer.appendChild(j);
    imgContainer.appendChild(i);
    bigContainer.append(i, j);
    cart.appendChild(bigContainer);
    if (!listName.includes(j.innerText)) {
        listName.push(j.innerText);
        console.log(listName);
    }

    i.addEventListener("click", (e) => delImg(i, j));
}

function delImg(i, j) {
    container.append(i);
    container.append(j);
    const bigContainer = document.createElement("div");
    const imgContainer = document.createElement("div");
    const dataContainer = document.createElement("div");

    bigContainer.style.display = "flex";
    bigContainer.style.flexDirection = "row";
    bigContainer.style.alignItems = "center";
    bigContainer.style.fontSize = "20px";
    bigContainer.style.fontWeight = "550";

    dataContainer.appendChild(j);
    imgContainer.appendChild(i);
    bigContainer.append(i, j);
    container.appendChild(bigContainer);
    const index = listName.indexOf(j.innerText);
    if (index !== -1) {
        listName.splice(index, 1);
    }
    console.log(listName);
    i.addEventListener("click", (e) => goCart(i, j));
}

$(document).ready(function(){
    $("#save").click(submit);
});

function submit(){
    const $textContent = document.getElementById("textContent");
    $textContent.value = listName.toString();

    const btn = document.getElementById('submit');
    btn.click();

    // console.log("hi");
    // $.ajax({
    //     url: "equipment",
    //     data: form,
    //     type: "POST",
    //     success : function(data){
    //         alert("성공")
    //     },
    //     error : function(){
    //         alert("에러")
    //     }
    // });
}
