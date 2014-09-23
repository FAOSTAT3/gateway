
var repository = '//fenixapps.fao.org/repository/js/';

require.config({

    baseUrl: '//168.202.28.57:8080',
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
        'FAOSTAT3_gateway_ga': 'faostat-gateway/static/faostat/faostat-gateway-js/faostat-ga',
        'FAOSTAT3_gateway_js': 'faostat-gateway/static/faostat/faostat-gateway-js/faostat-gateway-js',
        'FENIXChartsLibrary' : repository + 'FENIXChartsLibrary/0.4/FENIXChartsLibrary',

        // Home
        'HOME'                          : 'faostat-gateway/static/faostat/faostat-home-js/faostat-home',
        'HOME_faostat-home-charts'           : 'faostat-gateway/static/faostat/faostat-home-js/faostat-home-charts',
        'HOME_faostat-home-database-updates' : 'faostat-gateway/static/faostat/faostat-home-js/database-updates',


        // Browse
        'BROWSE'                          : 'faostat-browse-js/js/faostat-browse',
        // TODO: that's a shared library
        'BROWSE_jshashtable'              : "faostat-browse-js/js/jshashtable",
        'BROWSE_google-analytics-manager'   :"faostat-browse-js/js/google-analytics-manager",
        'BROWSE_faostat-browse-tree'        :"faostat-browse-js/js/faostat-browse-tree",
        'BROWSE_UIBuilder'                  :"faostat-browse-js/js/UIBuilder",
        'BROWSE_UIBuilderGrowthRate'        :"faostat-browse-js/js/UIBuilderGrowthRate",
        'BROWSE_UIBuilderTable'             :"faostat-browse-js/js/UIBuilderTable",
        'BROWSE_UIBuilderMap'               :"faostat-browse-js/js/UIBuilderMap",
        'BROWSE_UIBuilderChart'             :"faostat-browse-js/js/UIBuilderChart",
        'BROWSE_UIBuilderObjectsStructure'  :"faostat-browse-js/js/UIBuilderObjectsStructure",
        'BROWSE_UIBuilderSelectors'         :"faostat-browse-js/js/UIBuilderSelectors",
        'BROWSE_I18NInjector'               :"faostat-browse-js/js/I18NInjector",
        'BROWSE_UIBuilderByCountry'         :"faostat-browse-js/js/UIBuilderByCountry",
        'BROWSE_UIBuilderRankings'          :"faostat-browse-js/js/UIBuilderRankings",
        'BROWSE_UIBuilderTabSelector'       :"faostat-browse-js/js/UIBuilderTabSelector",
        'BROWSE_Export'                     :"faostat-browse-js/js/Export",
        'BROWSE_FAOSTATBrowseUtils'         :"faostat-browse-js/js/FAOSTATBrowseUtils",


        // Compare
        'compare'                          : 'faostat-compare-js/js/faostat-compare',
        // TODO: that's a shared library
        'compare-jshashtable'              : "faostat-compare-js/js/jshashtable",


        // Analysis
        'ANALYSIS_TILE_MANAGER' : 'analysis/js/tiles-manager/tiles-manager',
        'ANALYSIS_F3_CHART'     : 'analysis/js/libs/commons/f3-chart',
        'ANALYSIS_GHG_QA_QC'    : 'analysis/js/ghg-qa-qc/ghg-qa-qc',
        'ANALYSIS_GHG_OVERVIEW' : 'analysis/js//ghg-overview/ghg-overview'


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
            'jquery.sticky'
        ],

        'HOME' : [
            'FAOSTAT3',
            // highcharts
            'highcharts',
            'highcharts_exporting',
            'HOME_faostat-home-charts',
            'HOME_faostat-home-database-updates'
        ],

        'BROWSE' : [

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
            'BROWSE_jshashtable',
            'BROWSE_google-analytics-manager',
            'BROWSE_faostat-browse-tree',
            'BROWSE_UIBuilder',
            'BROWSE_UIBuilderGrowthRate',
            'BROWSE_UIBuilderTable',
            'BROWSE_UIBuilderMap',
            'BROWSE_UIBuilderChart',
            'BROWSE_UIBuilderObjectsStructure',
            'BROWSE_UIBuilderSelectors',
            'BROWSE_I18NInjector',
            'BROWSE_UIBuilderByCountry',
            'BROWSE_UIBuilderRankings',
            'BROWSE_UIBuilderTabSelector',
            'BROWSE_Export',
            'BROWSE_FAOSTATBrowseUtils'
        ],

        'download' : [

        ],

        'compare' : [

        ],


        'mes' : [

        ]


    }

});