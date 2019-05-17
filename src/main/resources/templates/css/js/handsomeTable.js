function createTable(result) {

   /* var dataObject=new Array(result.length);
    var i=0;
    for (i;i<result.length;i++){

        dataObject[i]={name: result.data[i].firstName + " " +result.data[i].lastName};
    }*/


    var dataObject = [];
    var len = result.data.length;
    console.log(len+"eeeeeee");
    for (var i = 0; i < len; i++) {
        dataObject.push({
            name: result.data[i].firstName + " " +result.data[i].lastName
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
            columns: [2],
            indicators: true
        }
    });

    //Hide license
    $("#hot-display-license-info").css("display", "none");
}

