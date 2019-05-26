function createTable(result) {

   /* var dataObject=new Array(result.length);
    var i=0;
    for (i;i<result.length;i++){

        dataObject[i]={name: result.data[i].firstName + " " +result.data[i].lastName};
    }*/


    var dataObject = [];
    var len = result.data.length;
    console.log(len+"eeeeeee");
    console.log(result.data[0].id);
    for (var i = 0; i < len; i++) {
        dataObject.push({
            name: result.data[i].firstName + " " +result.data[i].lastName,
            id: result.data[i].id
        });
    }


    console.log(dataObject);

/*    var dataObject = [
        {

            name: 'EUR'
        },
        {

            name: 'JPY'
        },
        {

            name: 'GBP'

        }
    ];*/
    var currencyCodes = ['EUR', 'JPY', 'GBP'];
    var hotElement = document.querySelector('#hot');
    var hotElementContainer = hotElement.parentNode;
    var hotSettings = {
        data: dataObject,
        columns: [
            {
                data: 'id'
            },
            {
                data: 'name'
            },
            {
                type: 'numeric',
                width: 40
            },

            {
                type: 'numeric',
                width: 40
            }
        ],
        stretchH: 'all',
        width: 880,
        autoWrapRow: true,
        height: 487,
        maxRows: 22,
        contextMenu: true,
        filters: true,
        dropdownMenu: true,
        rowHeaders: true,
        colHeaders: [
            'Id',
            'Name'
        ],
        columnSorting: {
            indicator: true
        },
        autoColumnSize: {
            samplingRatio: 23
        }
    };
    var hot = new Handsontable(hotElement, hotSettings);
    hot.updateSettings({
        hiddenColumns: {
            columns: [0],
            indicators: false
        }
    });
    var plugin = hot.getPlugin('hiddenColumns');

    //Hide license
    $("#hot-display-license-info").css("display", "none");

    plugin.showColumn(0);
    console.log(plugin.showColumn(0));

}

