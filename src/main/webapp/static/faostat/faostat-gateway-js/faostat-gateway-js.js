if (!window.FAOSTATGateway) {

    window.FAOSTATGateway = {


        /**
         * This map is used to avoid modules libraries to be loaded more than once.
         */
        loadUI : function() {
            // fix to load async labels. TODO: make it nicer
            CORE.getLangProperties();
            //FAOSTATGateway._loadLabels();
            FAOSTATGateway._loadListeners();

            // Enable the feedback System
            FAOSTATGateway._loadFeedbackSystem('faostat-feedback-system');
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
            CORE.getLangProperties();

            $('#home').append($.i18n.prop('_home'));
            $('#browse').append($.i18n.prop('_browse'));
            $('#download').append($.i18n.prop('_download'));
            $('#compare').append($.i18n.prop('_compare'));
            $('#search').append($.i18n.prop('_search'));
            $('#analysis').append($.i18n.prop('_analysis'));
            $('#mes').append($.i18n.prop('_mes'));

            /** labels **/
            $('.ico-pr').append($.i18n.prop('_production'));
            $('.ico-tr').append($.i18n.prop('_trade'));
            $('.ico-fs').append($.i18n.prop('_foodSupply'));
            $('.ico-re').append($.i18n.prop('_resources'));
            $('.ico-em').append($.i18n.prop('_ghg'));
            $('.ico-el').append($.i18n.prop('_ghgLandUse'));
            $('.ico-in').append($.i18n.prop('_investment'));
            $('.ico-fo').append($.i18n.prop('_forestry'));
            $('.ico-pi').append($.i18n.prop('_prices'));
            $('.ico-ae').append($.i18n.prop('_agriEnviromental'));
            $('.ico-fb').append($.i18n.prop('_foodBalanceSheet'));
            $('.ico-asti').append($.i18n.prop('_asti'));
            $('.ico-po').append($.i18n.prop('_population'));
            $('.ico-cb').append($.i18n.prop('_commoditybalances'));

            /** enable menu **/
            UIUtils.initializeDDMenu('browse', 'menu-dropdown-browse', 'menu-dropdown-download');
            UIUtils.initializeDDMenu('download', 'menu-dropdown-download', 'menu-dropdown-browse');
        },

        _loadFeedbackSystem: function(id) {
            $("#" + id).fancybox();
        }

    };

}