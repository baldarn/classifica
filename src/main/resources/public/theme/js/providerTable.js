var table = $('#table');

var oTable = table.dataTable({

    // Internationalisation. For more info refer to http://datatables.net/manual/i18n
    "language": {
        "aria": {
            "sortAscending": ": activate to sort column ascending",
            "sortDescending": ": activate to sort column descending"
        },
        "emptyTable": "No data available in table",
        "info": "Showing _START_ to _END_ of _TOTAL_ entries",
        "infoEmpty": "No entries found",
        "infoFiltered": "(filtered1 from _MAX_ total entries)",
        "lengthMenu": "Show _MENU_ entries",
        "search": "Search:",
        "zeroRecords": "No matching records found"
    },

    "columnDefs": [{
        "orderable": false,
        "targets": [0]
    }],
    "order": [
        [1, 'asc']
    ],
    "lengthMenu": [
        [5, 15, 20, -1],
        [5, 15, 20, "All"] // change per page values here
    ],
    // set the initial value
    "pageLength": 10,
});

var tableWrapper = $('#table_wrapper'); // datatable creates the table wrapper by adding with id {your_table_jd}_wrapper
var tableColumnToggler = $('#table_column_toggler');

/* modify datatable control inputs */
tableWrapper.find('.dataTables_length select').select2(); // initialize select2 dropdown


/* handle show/hide columns*/
$('input[type="checkbox"]', tableColumnToggler).change(function () {
    /* Get the DataTables object again - this is not a recreation, just a get of the object */
    var iCol = parseInt($(this).attr("data-column"));
    var bVis = oTable.fnSettings().aoColumns[iCol].bVisible;
    oTable.fnSetColumnVis(iCol, (bVis ? false : true));
});