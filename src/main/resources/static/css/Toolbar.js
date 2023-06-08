const li = document.getElementById("btnSet");
const $bt = document.getElementById("container");
const $listBtn = document.getElementById("listBtn");

function toggle() {
  if (li.style.display !== "none") {
    $bt.style.opacity = 1;
    li.style.display = "none";
  } else {
    $bt.style.opacity = 0.4;
    li.style.opacity = 1;
    li.style.display = "flex";
  }
}
$listBtn.addEventListener("click", toggle);