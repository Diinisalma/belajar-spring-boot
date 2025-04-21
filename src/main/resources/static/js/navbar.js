document.addEventListener('DOMContentLoaded', function() {
    const mobileMenuButton = document.querySelector('[aria-controls="mobile-menu"]');
    const mobileMenu = document.getElementById('mobile-menu');
    
    if (mobileMenuButton && mobileMenu) {
        mobileMenuButton.addEventListener('click', function() {
            // Toggle the aria-expanded attribute
            const isExpanded = mobileMenuButton.getAttribute('aria-expanded') === 'true';
            mobileMenuButton.setAttribute('aria-expanded', !isExpanded);
            
            // Toggle the mobile menu visibility
            mobileMenu.classList.toggle('hidden');
            
            // Toggle the menu icons
            const menuOpenIcon = mobileMenuButton.querySelector('.block');
            const menuCloseIcon = mobileMenuButton.querySelector('.hidden');
            
            if (menuOpenIcon && menuCloseIcon) {
                menuOpenIcon.classList.toggle('hidden');
                menuOpenIcon.classList.toggle('block');
                menuCloseIcon.classList.toggle('hidden');
                menuCloseIcon.classList.toggle('block');
            }
        });
    }
}); 