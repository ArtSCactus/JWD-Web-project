function toggleSidePanel() {
    var checkbox = document.getElementById('nav-toggle');
    var menu = document.getElementById('side-menu');
    if (checkbox.checked){
        menu.style.left = '-20%';
        menu.style.position = 'fixed';
        checkbox.style.left='20%';
    } else {
        checkbox.style.left="0%";
        menu.style.left = '0';
        menu.style.position = "relative";
    }
}