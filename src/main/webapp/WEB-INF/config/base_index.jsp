<%@ page language="java" %>
<%
    String BASE_URL = "http://localhost:8080/";
%>
<html>

    <head>

        <title>FAOSTAT Gateway</title>
        <link rel='icon' type='image/png' href='http://fenixapps.fao.org/repository/favicon/faostat.png'>

        <!-- JQuery -->
        <script type='text/javascript' src='http://fenixapps.fao.org/repository/js/jquery/1.8.1/jquery.min.js'></script>
        <script type='text/javascript' src='http://fenixapps.fao.org/repository/js/jquery/1.0.9/jquery.i18n.properties-min.js'></script>
        <script type='text/javascript' src='http://fenixapps.fao.org/repository/js/jquery/1.8.0/jquery.url.js'></script>
        <script type='text/javascript' src='http://fenixapps.fao.org/repository/js/jquery.number/2.1.0/jquery.number.js'></script>

        <!-- Highcharts -->
        <script type='text/javascript' src='http://fenixapps.fao.org/repository/js/highcharts/2.3.5/js/highcharts.js'></script>
        <script type='text/javascript' src='http://fenixapps.fao.org/repository/js/FENIXChartsLibrary/0.1/FENIXChartsLibrary.js'></script>

        <!-- JQWidgets -->
        <script type='text/javascript' src='http://fenixapps.fao.org/repository/js/jqwidgets/2.7/jqxcore.js'></script>
        <script type='text/javascript' src='http://fenixapps.fao.org/repository/js/jqwidgets/2.7/jqxbuttons.js'></script>
        <script type='text/javascript' src='http://fenixapps.fao.org/repository/js/jqwidgets/2.7/jqxscrollbar.js'></script>
        <script type='text/javascript' src='http://fenixapps.fao.org/repository/js/jqwidgets/2.7/jqxpanel.js'></script>
        <script type='text/javascript' src='http://fenixapps.fao.org/repository/js/jqwidgets/2.7/jqxlistbox.js'></script>
        <script type='text/javascript' src='http://fenixapps.fao.org/repository/js/jqwidgets/2.7/jqxdropdownlist.js'></script>
        <script type='text/javascript' src='http://fenixapps.fao.org/repository/js/jqwidgets/2.7/jqxtree.js'></script>
        <script type='text/javascript' src='http://fenixapps.fao.org/repository/js/jqwidgets/2.7/jqxexpander.js'></script>
        <script type='text/javascript' src='http://fenixapps.fao.org/repository/js/jqwidgets/2.7/jqxdata.js'></script>
        <script type='text/javascript' src='http://fenixapps.fao.org/repository/js/jqwidgets/2.7/jqxcombobox.js'></script>

        <!-- FAOSTAT Browse -->
        <script type='text/javascript' src='<%=BASE_URL%>faostat-browse-js/js/faostat-browse.js'></script>
        <script type='text/javascript' src='http://localhost:8080/faostat-browse-js/js/faostat-browse-faostat-browse-tree.js'></script>
        <script type='text/javascript' src='http://localhost:8080/faostat-browse-js/js/UIBuilder.js'></script>
        <script type='text/javascript' src='http://localhost:8080/faostat-browse-js/js/UIBuilderGrowthRate.js'></script>
        <script type='text/javascript' src='http://localhost:8080/faostat-browse-js/js/UIBuilderTable.js'></script>
        <script type='text/javascript' src='http://localhost:8080/faostat-browse-js/js/UIBuilderMap.js'></script>
        <script type='text/javascript' src='http://localhost:8080/faostat-browse-js/js/UIBuilderChart.js'></script>
        <script type='text/javascript' src='http://localhost:8080/faostat-browse-js/js/UIBuilderObjectsStructure.js'></script>
        <script type='text/javascript' src='http://localhost:8080/faostat-browse-js/js/UIBuilderSelectors.js'></script>
        <script type='text/javascript' src='http://localhost:8080/faostat-browse-js/js/I18NInjector.js'></script>
        <script type='text/javascript' src='http://localhost:8080/faostat-browse-js/js/UIBuilderByCountry.js'></script>
        <script type='text/javascript' src='http://localhost:8080/faostat-browse-js/js/UIBuilderRankings.js'></script>
        <script type='text/javascript' src='http://localhost:8080/faostat-browse-js/js/Export.js'></script>
        <script type='text/javascript' src='http://localhost:8080/faostat-browse-js/js/FAOSTATBrowseUtils.js'></script>

        <!-- Load Modules -->
        <script type="text/javascript">
            function loadModule(module) {
                window.location.href = 'http://localhost:8080/faostat-gateway/go/to/' + module + '/QC/Q';
            }
        </script>

        <!-- FAOSTAT Gateway's CSS -->
        <link type='text/css' rel='stylesheet' href='http://localhost:8080/faostat-browse-js/css/faostat-browse.css' />
        <link type='text/css' rel='stylesheet' href='http://localhost:8080/faostat-browse-js/css/widget.css' />
        <link href="http://fenixapps.fao.org/repository/css/faostat-gateway/0.1/gateway.css" type="text/css" rel="stylesheet">
        <link type='text/css' rel='stylesheet' href='http://fenixapps.fao.org/repository/css/jqwidgets/2.3.1/styles/jqx.base.css' />

    </head>

    <body>

        <div class="siteContainer">
            <div class="headBg">
                <div class="headWrapper">
                    <div class="logoFao">
                        <a target="_blank" href="http://www.fao.org/index_en.htm">
                            <img width="358" height="50" alt="FAO" src="http://fenixapps.fao.org/repository/css/faostat-gateway/0.1/faostat-images/logo-Fao.png">
                        </a>
                    </div>
                    <div class="langCont">
                        <table>
                            <tbody>
                            <tr>
                                <td class="lan_underline"> english </td>
                                <td class="lan">
                                    <a href="index_fr.html?locale=fr">fran&ccedil;ais</a>
                                </td>
                                <td class="lan">
                                    <a href="index_es.html?locale=es">espa&ntilde;ol</a>
                                </td>
                            </tr>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
            <div>
                <table style="border-collapse: collapse; width: 100%">
                    <tr>
                        <td class="menuitem" onclick="loadModule('home');">Home</td>
                        <td class="menuitem" onclick="loadModule('browse');">Browse Data</td>
                        <td class="menuitem" onclick="loadModule('download');">Download Data</td>
                        <td class="menuitem" onclick="loadModule('compare');">Compare Data</td>
                        <td class="menuitem" onclick="loadModule('search');">Search Data</td>
                        <td class="menuitem" onclick="loadModule('analysis');">Analysis</td>
                        <td class="menuitem" onclick="loadModule('mes');">Methods & Standards</td>
                    </tr>
                </table>
            </div>
        </div>

        <table align='center' style='width: 1000px; border-collapse: collapse;'>
            <tr>
                <td>$_CONTENT</td>
            </tr>
        </table>

    </body>

</html>