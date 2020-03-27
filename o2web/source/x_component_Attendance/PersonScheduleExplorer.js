MWF.xDesktop.requireApp("Template", "Explorer", null, false);
MWF.xDesktop.requireApp("Attendance", "Explorer", null, false);
MWF.xDesktop.requireApp("Selector", "package", null, false);
MWF.xApplication.Attendance.PersonScheduleExplorer = new Class({
    Extends: MWF.xApplication.Attendance.Explorer,
    Implements: [Options, Events],

    initialize: function (node, app, actions, options) {
        this.setOptions(options);
        this.app = app;
        this.path = "/x_component_Attendance/$PersonScheduleExplorer/";
        this.cssPath = "/x_component_Attendance/$PersonScheduleExplorer/" + this.options.style + "/css.wcss";
        this._loadCss();

        this.actions = actions;
        this.node = $(node);

        this.initData();
        if (!this.personActions) this.personActions = new MWF.xAction.org.express.RestActions();
    },
    loadToolbar: function(){
        var style = this.css.toolbarNode;
        style['height'] = '70px';
        this.toolbarNode = new Element("div", {"styles": style});
        this.toolbarNode.inject(this.node);

        new Request({
            url:'http://122.224.253.202:20020/x_organization_assemble_express/jaxrs/unit/list/all',
            method:'GET',
            dataType:'json',
            headers : {'Content-Type':'application/json;charset=utf8'},
            withCredentials:true,
            onRequest: function(){ },
            onSuccess: responseText=>{
                var json = JSON.parse(responseText)['data']['unitList'];
                json.forEach(unit=>{
                    this.createToolbarItemNode({
                        "access" : "admin",
                        "title": unit.split("@")[0],
                        "id": "1.1",
                        "action": unit,
                        "icon": "create.png",
                        "expand": false,
                        "position" : "left",
                        "styles" : "toolbarItemNode",
                        "sub": []
                    });
                    this[unit] = function(){
                        console.log(unit);
                    }
                })
            },
            onFailure: function(){}
        }).send();
    },
    // loadView: function () {
    //     this.view = new MWF.xApplication.Attendance.PersonScheduleExplorer.View(this.elementContentNode, this.app, this, this.viewData, this.options.searchKey);
    //     this.view.load();
    //     this.setContentSize();
    // },
    createDocument: function () {
        //if (this.view) this.view._createDocument();
    }
});

MWF.xApplication.Attendance.PersonScheduleExplorer.View = new Class({
    initialize: function (container, app, explorer, searchKey) {
        this.container = container;
        this.app = app;
        this.explorer = explorer;
        this.css = explorer.css;
        this.actions = explorer.actions;
        this.searchKey = searchKey;
        this.listItemUrl = this.explorer.path + "listItem.json";
    },
    initData: function () {
        this.items = [];
        this.documents = {};
        this.isItemsLoaded = false;
        this.isItemLoadding = false;
        this.loadItemQueue = 0;
        this.count = 0;
        //this.controllers =[];
    },
    load: function () {
        this.initData();
        this.node = new Element("div", {
            "styles": this.css.elementContentListNode
        }).inject(this.container);
        this.calendarNode = new Element("div.calendarNode", {
            "styles": this.css.calendarNode
        }).inject(this.node);
        var date = new Date();
        this.calendar = new MWF.xApplication.Attendance.Calendar(this.calendarNode, this,
            {
                "holiday": {},
                "detail": {},
                "eventData": []
            }, {
                date: date,
                cycleStart: new Date(date.getFullYear(), date.getMonth(), 1),
                cycleEnd: new Date(date.getFullYear(), date.getMonth() + 1, 0)
            }, function (date, jsEvent, view) {
                console.log(this.explorer);
                var schedule = new MWF.xApplication.Attendance.PersonScheduleExplorer.Schedule(this.explorer);
                schedule.date = date;
                schedule.create();
            }.bind(this),
        );
        this.calendar.load();
    },
    reload: function(){
        //this.load();
    }
});

MWF.xApplication.Attendance.PersonScheduleExplorer.Document = new Class({
    Extends: MWF.xApplication.Attendance.Explorer.Document

});


MWF.xApplication.Attendance.PersonScheduleExplorer.Schedule = new Class({
    Extends: MWF.xApplication.Attendance.Explorer.PopupForm,
    options: {
        "width": 600,
        "height": 450,
        "hasTop": true,
        "hasBottom": true,
        "title": "",
        "draggable": true,
        "closeAction": true
    },
    _createTableContent: function () {
        var lp = this.app.lp.schedule;

        var html = "<table width='100%' bordr='0' cellpadding='5' cellspacing='0' styles='formTable'>" +
            "<tr><td colspan='2' styles='formTableHead'>" + lp.setSchedule + "</td></tr>" +
            "<tr><td styles='formTabelTitle' lable='employeeName'></td>" +
            "    <td styles='formTableValue' item='employeeName'></td></tr>" +
            "<tr><td styles='formTabelTitle' lable='onDutyTime'></td>" +
            "    <td styles='formTableValue' item='onDutyTime'></td></tr>" +
            "<tr><td styles='formTabelTitle' lable='offDutyTime'></td>" +
            "    <td styles='formTableValue' item='offDutyTime'></td></tr>" +
            "<tr><td styles='formTabelTitle' lable='lateStartTime'></td>" +
            "    <td styles='formTableValue' item='lateStartTime'></td></tr>" +
            "<tr><td styles='formTabelTitle' lable='leaveEarlyStartTime'></td>" +
            "    <td styles='formTableValue' item='leaveEarlyStartTime'></td></tr>" +
            "<tr><td styles='formTabelTitle' lable='absenceStartTime'></td>" +
            "    <td styles='formTableValue' item='absenceStartTime'></td></tr>" +
            "</table>";
        this.formTableArea.set("html", html);

        MWF.xDesktop.requireApp("Template", "MForm", function () {
            this.form = new MForm(this.formTableArea, this.data, {
                isEdited: this.isEdited || this.isNew,
                itemTemplate: {
                    employeeName : { text:"员工姓名", type : "org", orgType : "person", notEmpty:true },
                    onDutyTime: {text: lp.workTime, tType: "time", notEmpty: true},
                    offDutyTime: {text: lp.offTime, tType: "time", notEmpty: true},
                    lateStartTime: {text: lp.lateTime, tType: "time", notEmpty: true},
                    leaveEarlyTime: {text: lp.leaveEarlyTime, tType: "time"},
                    absenceStartTime: {text: lp.absenteeismTime, tType: "time"}
                }
            }, this.app);
            this.form.load();
        }.bind(this), true);
    },
    _ok: function (data, callback) {
        console.log(this.date);
        var date = this.date._i;
        console.log(data);

        new Request({
            url:'http://122.224.253.202:20020/x_query_assemble_surface/jaxrs/table/6bdc1784-946d-441b-8c92-d1b2a500ccf0/row',
            method:'POST',
            dataType:'json',
            headers : {'Content-Type':'application/json;charset=utf8'},
            withCredentials: true,
            data:JSON.stringify({"username":"employeeName","onDutyTime":date+" "+data.onDutyTime+":00","offDutyTime":date+" "+data.offDutyTime+":00","status":"未打卡"}),
            onRequest: function(){ },
            onSuccess: function(responseText){
                console.log(JSON.parse(responseText));
            },
            onFailure: function(){}
        }).send();
        if(callback) callback({type:'success'});
        // this.app.restActions.saveSchedule(data, function (json) {
        //     if (callback) callback(json);
        // }.bind(this));
    }
});
