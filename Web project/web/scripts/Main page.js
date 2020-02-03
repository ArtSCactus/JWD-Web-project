/**
 * @author ArtSCactus
 */
function updateSpecialtiesBlock() {
    var checkBoxStatus = document.querySelector('input[type=checkbox]');
    if (checkBoxStatus.checked) {
        var specialtiesArray = document.getElementsByClassName("specialty_item");
        for (var index = 0; index < specialtiesArray.length; index++) {
            specialtiesArray[index].style.display = "none";
        }
    } else {
        var specialtiesArray = document.getElementsByClassName("specialty_item");
        for (var index = 0; index < specialtiesArray.length; index++) {
            specialtiesArray[index].style.display = "flex";
        }
    }
}
