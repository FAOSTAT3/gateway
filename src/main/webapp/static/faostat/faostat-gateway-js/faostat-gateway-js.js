if (!window.FAOSTATGateway) {

    window.FAOSTATGateway = {


        /**
         * This map is used to avoid modules libraries to be loaded more than once.
         */
        loadUI : function(module) {
            // Select the module on the Menu
            $('#'  + module).addClass("fs-menu-selected");

            // fix to load async labels. TODO: make it nicer
            CORE.getLangProperties(FAOSTATGateway._loadLabels);
            //FAOSTATGateway._loadLabels();
            FAOSTATGateway._loadListeners();

            // Enable the feedback System
            FAOSTATGateway._loadFeedbackSystem('faostat-feedback-system');

            FAOSTATGateway._inizializeDD();

            $.scrollUp({
                scrollName: 'scrollUp', // Element ID
                scrollDistance: 150, // Distance from top/bottom before showing element (px)
                scrollFrom: 'top', // 'top' or 'bottom'
                scrollSpeed: 300, // Speed back to top (ms)
                easingType: 'linear', // Scroll to top easing (see http://easings.net/)
                animation: 'fade', // Fade, slide, none
                animationSpeed: 200, // Animation speed (ms)
                scrollText: '<i class="fa fa-chevron-circle-up fa-2x"></i>', // Text for element, can contain HTML
                activeOverlay: false, // Set CSS color to display scrollUp active point, e.g '#00FFFF'
                zIndex: 2147483647 // Z-Index for the overlay
            });


        },

        _loadListeners: function() {
            $("#searchFS").on("submit", function() {
                var q = document.getElementById('searchFStext').value;
                CORE.loadModule('search', q);
                return false;
            });
            // Reload of the modules in the different languages
            $("#langE").on("click", function() { CORE.reloadModule('E'); });
            $("#langF").on("click", function() { CORE.reloadModule('F'); });
            $("#langS").on("click", function() { CORE.reloadModule('S'); });
        },

        _loadLabels: function() {
            /** setting lang properties **/

            $('#fs-fao').html($.i18n.prop('_fao'));
            $('#home').html($.i18n.prop('_home'));
            $('#browse').html($.i18n.prop('_browse'));
            $('#download').html($.i18n.prop('_download'));
            $('#compare').html($.i18n.prop('_compare'));
            $('#search').html($.i18n.prop('_search'));
            $('#analysis').html($.i18n.prop('_analysis'));
            $('#mes').html($.i18n.prop('_mes'));

            $("#searchFStext").attr('placeholder', $.i18n.prop('_searchText'));
        },

        _inizializeDD: function() {
            /** enable menu **/
            UIUtils.initializeDDMenu('browse', 'menu-dropdown-browse', 'menu-dropdown-download');
            UIUtils.initializeDDMenu('download', 'menu-dropdown-download', 'menu-dropdown-browse');
        },

        _loadFeedbackSystem: function(id) {
            $("#" + id).fancybox();
        }

    };

}