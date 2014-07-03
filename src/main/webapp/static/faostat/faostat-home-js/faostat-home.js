if (!window.FAOSTATHome) {

    window.FAOSTATHome = {


        /**
         * This map is used to avoid modules libraries to be loaded more than once.
         */
       loadUI : function(lang) {
             //FAOSTATHome._labels();
            FAOSTATDatabaseUpdate.getDatabaseUpdates(CORE.datasource, CORE.lang);
            FS_HOME_CHART.init();

            CORE.getLangProperties(FAOSTATHome._labels)
            FAOSTATHome._loadNews('whatsNew-content', 'whatsNew', lang);
            FAOSTATHome._loadNews('comingUp-content', 'comingUp', lang);
            FAOSTATHome._loadLinks('fs-links-content', lang);
            FAOSTATHome._showBulkDownload();
        },

        _loadNews: function(id, type, lang) {
            var url = 'http://' + CORE.baseURL + '/faostat-gateway/static/faostat/faostat-home-js/resources/' + type +'.json';
            $('#' + id).empty()
            $.getJSON(url, function(data) {
                for( var i=0; i < data.length; i++) {
                    var html = '<h4>'+ data[i].title[lang] + '</h3>';
                    html += '<p>' + data[i].description[lang] +'</p>';
                    html += '<br>';
                    $('#' + id).append(html);
                }
            });
        },

        _loadLinks: function(id, lang) {

            var url = 'http://' + CORE.baseURL + '/faostat-gateway/static/faostat/faostat-home-js/resources/links.json';
            $.getJSON(url, function(data) {
                $('#' + id).empty()
                for( var i=0; i < data.length; i++) {
                    var html = '<a href="' + data[i].link[lang] +'" target="_blank">'+ data[i].title[lang] +'</a>';
                    $('#' + id).append(html);
                }
            });

        },

        _labels: function() {
            /** setting lang properties **/
           // CORE.getLangProperties(FAOSTATHome._loadLabels);

            /* labels */
            $('#whatsNewText').html($.i18n.prop('_whatsNew'));
            $('#databaseUpdatesText').html($.i18n.prop('_databaseUpdates'));
            $('#comingUpText').html($.i18n.prop('_comingUp'));
            $('#releaseCalendarText').html($.i18n.prop('_releaseCalendar'));
            $('#partners').html($.i18n.prop('_partners'));
            $('#faoLinks').html($.i18n.prop('_faoLinks'));

            /** tooltips **/
            $('#ifpri').attr("title", "International Food Policy Research Institute (IFPRI)");
            $("#ifpri").powerTip({placement: 's'});

            $('#ilo').attr("title","International Labour Organization (ILO)");
            $("#ilo").powerTip({placement: 's'});

            $('#oecd').attr("title","Organisation for Economic Co-operation and Development (OECD)");
            $("#oecd").powerTip({placement: 's'});

            $('#unfccc').attr("title","United Nations Framework Convention on Climate Change (UNFCC)");
            $("#unfccc").powerTip({placement: 's'});

            $('#unstats').attr("title","United Nations Statistics Division (UNSTATS)");
            $("#unstats").powerTip({placement: 's'});

            $('#usda').attr("title","United States Department of Agriculture (USDA)");
            $("#usda").powerTip({placement: 's'});

            $('worldbank').attr("title","World Bank" );
            $("#worldbank").powerTip({placement: 's'});

            $('#wto').attr("title", "World Trade Organization (WTO)");
            $("#wto").powerTip({placement: 's'});

            /** labels **/
//            $('.ico-pr').html($.i18n.prop('_production'));
//            $('.ico-tr').html($.i18n.prop('_trade'));
//            $('.ico-fs').html($.i18n.prop('_foodSupply'));
//            $('.ico-fsecurity').html($.i18n.prop('_foodsecurity'));
//            $('.ico-re').html($.i18n.prop('_resources'));
//            $('.ico-em').html($.i18n.prop('_ghg'));
//            $('.ico-el').html($.i18n.prop('_ghgLandUse'));
//            $('.ico-in').html($.i18n.prop('_investment'));
//            $('.ico-fo').html($.i18n.prop('_forestry'));
//            $('.ico-pi').html($.i18n.prop('_prices'));
//            $('.ico-ae').html($.i18n.prop('_agriEnviromental'));
//            $('.ico-fb').html($.i18n.prop('_foodBalance'));
//            $('.ico-asti').html($.i18n.prop('_asti'));
//            $('.ico-pop').html($.i18n.prop('_population'));
//            $('.ico-po').html($.i18n.prop('_population'));
//            $('.ico-cb').html($.i18n.prop('_commoditybalances'));
//            $('.ico-emergencyresponse').html($.i18n.prop('_emergency_response'));

            $('.fs-browse-text').html($.i18n.prop('_fs_browse_text'));
            $('.fs-download-text').html($.i18n.prop('_fs_download_text'));

            $('#fs-home-find-data').html($.i18n.prop('_fs_home_find_data'));

            $('.fs-rankings').html($.i18n.prop('_fs_rankings') + " ");
            $('.fs-country-region').html($.i18n.prop('_fs_country_region')+ " ");

            $('.fs-arrow').append($.i18n.prop('_fs_arrow'));

            $('#fs-coming-soon').html($.i18n.prop('_fs_coming_soon'));

            $('#fs-country-profiles').html($.i18n.prop('_fs_country_profiles'));
            $('#fs-country-profiles').click(function() {
               alert("add country profile")
            });

            $('#fs-essdd').prepend($.i18n.prop('_essdd'));

            $('#fs-release-calendar').prepend($.i18n.prop('_releaseCalendar'));

            $('#FAOSTAT-ZIP-Download').append($.i18n.prop('_downloadZip'));
            $('#FAOSTAT-ZIP-Download').append($.i18n.prop('_database'));
            $('#FAOSTAT-ZIP-Download').append($.i18n.prop('_withoneclick'));


            $("#fs-home-sy").html($.i18n.prop('_fs_sy'));
            $("#fs-home-sy-2013").prepend($.i18n.prop('_fs_sy'));
            $("#fs-home-sy-description").html($.i18n.prop('_fs_sy_description'));
            $("#partners").html($.i18n.prop('_partners'));
            $("#fs-featured-links").html($.i18n.prop('_featured_links'));
            $("#fs-contacts").html($.i18n.prop('_contacts'));
        },

        _showBulkDownload: function() {
            $.ajax({
                type: 'GET',
                url: 'http://' + CORE.baseURL + '/wds/rest/bulkdownloads/' + CORE.datasource + '/0/E',
                dataType: 'json',
                success: function (response) {
                    if (typeof response == 'string')
                        response = $.parseJSON(response);
                    document.getElementById('faostat-download-zip-date').innerHTML = response[0][4].substring(0, 10);
                },
                error: function (err, b, c) {
                }
            });

            $("#FAOSTAT-ZIP-Download").click(function(){
                window.open("ftp://ext-ftp.fao.org/ES/Reserved/essb/ess/ftp_essb/FAOSTAT/BulkDownloads/FAOSTAT.zip", "_blank");
                FAOSTAT_STATS.bulkDownloadZip();
            });
        }
    };

}