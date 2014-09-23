
var repository = '//fenixapps.fao.org/repository/js/';

require.config({

    baseUrl: '//168.202.28.214:8080',
    paths: {
        'jquery'               : repository + 'jquery/1.10.2/jquery-1.10.2.min',
        'jquery.i18n'          : repository + 'jquery/1.0.9/jquery.i18n.properties-min',
        'jquery.powertip.min'  : repository + 'jquery.power.tip/1.1.0/jquery.powertip.min',
        'jquery.sticky'        : repository + 'stickyjs/1.0/jquery.sticky',
        'jquery.history'       : repository + 'history.js/1.8b2/html4+html5/jquery.history',
        'jquery.scrollUp.min'  : repository + 'scrollup/2.3.3/js/jquery.scrollUp.min',

         // TODO: move it from faostat-download
        'jquery.chromatable'    : 'faostat-download-js/js/chromatable/jquery.chromatable',
        'jquery.mousewheel'     : 'faostat-download-js/js/chromatable/jquery.mousewheel-3.0.6.pack',
        'jquery.fancybox'       : 'faostat-download-js/js/chromatable/jquery.fancybox',


        'bootstrap': repository + 'bootstrap/3.2/js/bootstrap.min',
        'chosen': repository + 'chosen/1.0.0/chosen.jquery.min',
        'highcharts': repository + 'highcharts/4.0.4/js/highcharts',
        'highcharts_exporting' : repository + 'highcharts/4.0.4/js/modules/exporting',

        'mustache': '//cdnjs.cloudflare.com/ajax/libs/mustache.js/0.8.1/mustache',

        'text': 'faostat-gateway/static/faostat/common/libs/text',

        // jqwidgets
        'jqxcore'  : repository + 'jqwidgets/2.8.3/jqxcore',
        'jqxtabs'  : repository + 'jqwidgets/2.8.3/jqxtabs',
        'jqxscrollbar'  : repository + 'jqwidgets/2.8.3/jqxscrollbar',
        'jqxpanel'  : repository + 'jqwidgets/2.8.3/jqxpanel',
        'jqxtree'  : repository + 'jqwidgets/2.8.3/jqxtree',
        'jqxexpander'  : repository + 'jqwidgets/2.8.3/jqxexpander',
        'jqxbuttons'  : repository + 'jqwidgets/2.8.3/jqxbuttons',
        'jqxlistbox'  : repository + 'jqwidgets/2.8.3/jqxlistbox',
        'jqxdropdownlist'  : repository + 'jqwidgets/2.8.3/jqxdropdownlist',
        'jqxcombobox'  : repository + 'jqwidgets/2.8.3/jqxcombobox',

        // Gateway
        'FAOSTAT3': 'faostat-gateway/static/faostat/faostat-gateway-js/core',
        'faostat-gateway-js' : 'faostat-gateway/static/faostat/faostat-gateway-js/faostat-gateway-js',
        'faostat-gateway-UIUtils' : 'faostat-gateway/static/faostat/faostat-gateway-js/UIUtils',
        'faostat-gateway-ga' : 'faostat-gateway/static/faostat/faostat-gateway-js/faostat-ga',
         'FENIXChartsLibrary' : repository + 'FENIXChartsLibrary/0.4/FENIXChartsLibrary',

        // Home
        'home'                          : 'faostat-gateway/static/faostat/faostat-home-js/faostat-home',
        'faostat-home-charts'           : 'faostat-gateway/static/faostat/faostat-home-js/faostat-home-charts',
        'faostat-home-database-updates' : 'faostat-gateway/static/faostat/faostat-home-js/database-updates',


        // Browse
        'browse'                          : 'faostat-browse-js/js/faostat-browse',
        // TODO: that's a shared library
        'browse-jshashtable'              : "faostat-browse-js/js/jshashtable",
        'browse-google-analytics-manager'   :"faostat-browse-js/js/google-analytics-manager",
        'browse-faostat-browse-tree'        :"faostat-browse-js/js/faostat-browse-tree",
        'browse-UIBuilder'                  :"faostat-browse-js/js/UIBuilder",
        'browse-UIBuilderGrowthRate'        :"faostat-browse-js/js/UIBuilderGrowthRate",
        'browse-UIBuilderTable'             :"faostat-browse-js/js/UIBuilderTable",
        'browse-UIBuilderMap'               :"faostat-browse-js/js/UIBuilderMap",
        'browse-UIBuilderChart'             :"faostat-browse-js/js/UIBuilderChart",
        'browse-UIBuilderObjectsStructure'  :"faostat-browse-js/js/UIBuilderObjectsStructure",
        'browse-UIBuilderSelectors'         :"faostat-browse-js/js/UIBuilderSelectors",
        'browse-I18NInjector'               :"faostat-browse-js/js/I18NInjector",
        'browse-UIBuilderByCountry'         :"faostat-browse-js/js/UIBuilderByCountry",
        'browse-UIBuilderRankings'          :"faostat-browse-js/js/UIBuilderRankings",
        'browse-UIBuilderTabSelector'       :"faostat-browse-js/js/UIBuilderTabSelector",
        'browse-Export'                     :"faostat-browse-js/js/Export",
        'browse-FAOSTATBrowseUtils'         :"faostat-browse-js/js/FAOSTATBrowseUtils",


        // Compare
        'compare'                          : 'faostat-compare-js/js/faostat-compare',
        // TODO: that's a shared library
        'compare-jshashtable'              : "faostat-compare-js/js/jshashtable",



        'F3_CHART': 'analysis/js/libs/commons/f3-chart',
        'GHG_COUNTRY_PROFILE': 'analysis/js/ghg-country-profile/ghg-country-profile',
        'GHGEDITOR': 'analysis/js/ghg-country-profile/ghg-editor',
        'GHG_OVERVIEW': 'analysis/js/ghg-overview/ghg-overview',
        'TILESMGR': 'analysis/js/tiles-manager/tiles-manager'

    },

    shim: {
        'bootstrap': ['jquery'],
        'chosen': ['jquery'],

        'underscore': {
            exports: '_'
        },

        'jquery.powertip.min': ['jquery'],
        'jquery.sticky': ['jquery'],
        'jquery.i18n': ['jquery'],
        'jquery.scrollUp.min': [ 'jquery'],
        'jquery.history': [ 'jquery'],

        'highcharts': ['jquery'],
        'highcharts_exporting' : [
            'highcharts'
        ],

        'FENIXChartsLibrary' : [
            'highcharts'
        ],

        'FAOSTAT3' : [
            'jquery',
            'jquery.i18n',
            'jquery.powertip.min',
            'jquery.history',
            'jquery.scrollUp.min',
            'jquery.sticky',
            'faostat-gateway-js',
            'faostat-gateway-ga'

        ],

        'home' : [
            'FAOSTAT3',
            // highcharts
            'highcharts',
            'highcharts_exporting',
            'faostat-home-charts',
            'faostat-home-database-updates'
        ],

        'browse' : [

            // jqwidgets
            'jqxcore',
            'jqxtabs',
            'jqxscrollbar',
            'jqxpanel',
            'jqxtree',
            'jqxexpander',
            'jqxbuttons',
            'jqxlistbox',
            'jqxdropdownlist',
            'jqxcombobox',

            // highcharts
            'highcharts',
            'highcharts_exporting',
            'FENIXChartsLibrary',

            // browse
            'browse-jshashtable',
            'browse-google-analytics-manager',
            'browse-faostat-browse-tree',
            'browse-UIBuilder',
            'browse-UIBuilderGrowthRate',
            'browse-UIBuilderTable',
            'browse-UIBuilderMap',
            'browse-UIBuilderChart',
            'browse-UIBuilderObjectsStructure',
            'browse-UIBuilderSelectors',
            'browse-I18NInjector',
            'browse-UIBuilderByCountry',
            'browse-UIBuilderRankings',
            'browse-UIBuilderTabSelector',
            'browse-Export',
            'browse-FAOSTATBrowseUtils'
        ],

        'download' : [

        ],

        'compare' : [

        ],

        'analysis' : [

        ],

        'mes' : [

        ]


    }

});