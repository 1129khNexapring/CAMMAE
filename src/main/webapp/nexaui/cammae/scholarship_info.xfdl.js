(function()
{
    return function()
    {
        if (!this._is_form)
            return;
        
        var obj = null;
        
        this.on_create = function()
        {
            this.set_name("scholarship_info");
            this.set_titletext("New Form");
            if (Form == this.constructor)
            {
                this._setFormPosition(800,600);
            }
            
            // Object(Dataset, ExcelExportObject) Initialize
            obj = new Dataset("ds_scholarship", this);
            obj.set_loadkeymode("keep");
            obj._setContents("<ColumnInfo><Column id=\"chk\" type=\"STRING\" size=\"256\"/><Column id=\"scholarship_inno\" type=\"INT\" size=\"256\"/><Column id=\"scholarship_avg_grade\" type=\"INT\" size=\"256\"/><Column id=\"scholarship_year\" type=\"STRING\" size=\"256\"/><Column id=\"scholarship_term\" type=\"STRING\" size=\"256\"/><Column id=\"scholarship_status\" type=\"STRING\" size=\"256\"/><Column id=\"scholarship_amount\" type=\"INT\" size=\"256\"/><Column id=\"scholarship_name\" type=\"STRING\" size=\"256\"/><Column id=\"scholarship_phonenumber\" type=\"STRING\" size=\"256\"/><Column id=\"scholarship_college\" type=\"STRING\" size=\"256\"/><Column id=\"scholarship_student_no\" type=\"INT\" size=\"256\"/><Column id=\"scholarship_manager_no\" type=\"INT\" size=\"256\"/></ColumnInfo><Rows><Row/></Rows>");
            this.addChild(obj.name, obj);


            obj = new Dataset("dsYear", this);
            obj._setContents("<ColumnInfo><Column id=\"scholarship_year\" type=\"STRING\" size=\"256\"/><Column id=\"scholarship_term\" type=\"STRING\" size=\"256\"/></ColumnInfo><Rows><Row><Col id=\"scholarship_year\">2022</Col><Col id=\"scholarship_term\">1</Col></Row><Row><Col id=\"scholarship_year\">2023</Col><Col id=\"scholarship_term\">1</Col></Row><Row><Col id=\"scholarship_year\">2024</Col><Col id=\"scholarship_term\">1</Col></Row><Row><Col id=\"scholarship_year\">2025</Col><Col id=\"scholarship_term\">1</Col></Row><Row><Col id=\"scholarship_year\">2026</Col><Col id=\"scholarship_term\">1</Col></Row><Row><Col id=\"scholarship_year\">2027</Col><Col id=\"scholarship_term\">1</Col></Row><Row><Col id=\"scholarship_year\">2028</Col><Col id=\"scholarship_term\">1</Col></Row><Row><Col id=\"scholarship_year\">2029</Col><Col id=\"scholarship_term\">1</Col></Row><Row><Col id=\"scholarship_year\">2030</Col><Col id=\"scholarship_term\">1</Col></Row><Row><Col id=\"scholarship_year\">2022</Col><Col id=\"scholarship_term\">2</Col></Row><Row><Col id=\"scholarship_year\">2023</Col><Col id=\"scholarship_term\">2</Col></Row><Row><Col id=\"scholarship_year\">2024</Col><Col id=\"scholarship_term\">2</Col></Row><Row><Col id=\"scholarship_year\">2025</Col><Col id=\"scholarship_term\">2</Col></Row><Row><Col id=\"scholarship_year\">2026</Col><Col id=\"scholarship_term\">2</Col></Row><Row><Col id=\"scholarship_year\">2027</Col><Col id=\"scholarship_term\">2</Col></Row><Row><Col id=\"scholarship_year\">2028</Col><Col id=\"scholarship_term\">2</Col></Row><Row><Col id=\"scholarship_year\">2029</Col><Col id=\"scholarship_term\">2</Col></Row><Row><Col id=\"scholarship_year\">2030</Col><Col id=\"scholarship_term\">2</Col></Row></Rows>");
            this.addChild(obj.name, obj);


            obj = new Dataset("dsTerm", this);
            obj._setContents("<ColumnInfo><Column id=\"scholarship_term\" type=\"STRING\" size=\"256\"/><Column id=\"scholarship_no\" type=\"INT\" size=\"256\"/></ColumnInfo><Rows><Row><Col id=\"scholarship_term\">1??????</Col><Col id=\"scholarship_no\">1</Col></Row><Row><Col id=\"scholarship_term\">2??????</Col><Col id=\"scholarship_no\">2</Col></Row></Rows>");
            this.addChild(obj.name, obj);


            obj = new Dataset("dsCollege", this);
            obj._setContents("<ColumnInfo><Column id=\"scholarship_college\" type=\"STRING\" size=\"256\"/><Column id=\"scholarship_collegeName\" type=\"STRING\" size=\"256\"/></ColumnInfo><Rows><Row><Col id=\"scholarship_college\">??????????????????</Col><Col id=\"scholarship_collegeName\">????????????</Col></Row><Row><Col id=\"scholarship_college\">?????????????????????</Col><Col id=\"scholarship_collegeName\">????????????</Col></Row><Row><Col id=\"scholarship_college\">?????????????????????</Col><Col id=\"scholarship_collegeName\">????????????</Col></Row><Row><Col id=\"scholarship_college\">???????????????</Col><Col id=\"scholarship_collegeName\">???????????????</Col></Row><Row><Col id=\"scholarship_college\">?????????????????????</Col><Col id=\"scholarship_collegeName\">????????????</Col></Row><Row><Col id=\"scholarship_college\">??????????????????</Col><Col id=\"scholarship_collegeName\">???????????????</Col></Row></Rows>");
            this.addChild(obj.name, obj);


            obj = new Dataset("ds_send", this);
            obj._setContents("<ColumnInfo><Column id=\"scholarship_year\" type=\"STRING\" size=\"256\"/><Column id=\"scholarship_term\" type=\"STRING\" size=\"256\"/><Column id=\"scholarship_college\" type=\"STRING\" size=\"256\"/></ColumnInfo><Rows><Row/></Rows>");
            this.addChild(obj.name, obj);
            
            // UI Components Initialize
            obj = new Div("Div04","0","70","800","60",null,null,null,null,null,null,this);
            obj.set_taborder("7");
            obj.set_text("");
            obj.set_background("rgb(231, 232, 226)");
            this.addChild(obj.name, obj);

            obj = new Button("btnCheck","559","85","60","25",null,null,null,null,null,null,this);
            obj.set_taborder("0");
            obj.set_text("??????");
            this.addChild(obj.name, obj);

            obj = new Combo("Combo00","68","87","120","20",null,null,null,null,null,null,this);
            obj.set_taborder("1");
            obj.set_innerdataset("dsYear");
            obj.set_datacolumn("scholarship_year");
            obj.set_codecolumn("scholarship_term");
            obj.set_text("2022");
            obj.set_value("1");
            obj.set_index("0");
            this.addChild(obj.name, obj);

            obj = new Combo("Combo01","241","87","120","20",null,null,null,null,null,null,this);
            obj.set_taborder("2");
            obj.set_innerdataset("dsTerm");
            obj.set_datacolumn("scholarship_term");
            obj.set_codecolumn("scholarship_no");
            obj.set_text("1??????");
            obj.set_value("1");
            obj.set_index("0");
            this.addChild(obj.name, obj);

            obj = new Combo("Combo02","410","87","120","20",null,null,null,null,null,null,this);
            obj.set_taborder("3");
            obj.set_datacolumn("scholarship_college");
            obj.set_codecolumn("scholarship_collegeName");
            obj.set_innerdataset("dsCollege");
            obj.set_text("??????????????????");
            obj.set_value("????????????");
            obj.set_index("0");
            this.addChild(obj.name, obj);

            obj = new Button("btn_accept","633","85","60","25",null,null,null,null,null,null,this);
            obj.set_taborder("4");
            obj.set_text("??????");
            this.addChild(obj.name, obj);

            obj = new Button("btn_denined","709","85","60","25",null,null,null,null,null,null,this);
            obj.set_taborder("5");
            obj.set_text("?????????");
            this.addChild(obj.name, obj);

            obj = new Grid("Grid00","0","160","800","350",null,null,null,null,null,null,this);
            obj.set_taborder("6");
            obj.set_autofittype("col");
            obj.set_binddataset("ds_scholarship");
            obj._setContents("<Formats><Format id=\"default\"><Columns><Column size=\"48\"/><Column size=\"80\"/><Column size=\"80\"/><Column size=\"80\"/><Column size=\"80\"/><Column size=\"80\"/><Column size=\"80\"/><Column size=\"80\"/><Column size=\"80\"/><Column size=\"80\"/></Columns><Rows><Row size=\"24\" band=\"head\"/><Row size=\"24\"/></Rows><Band id=\"head\"><Cell text=\"chk\" edittype=\"checkbox\" displaytype=\"checkboxcontrol\"/><Cell col=\"1\" text=\"??????\"/><Cell col=\"2\" text=\"??????\"/><Cell col=\"3\" text=\"??????\"/><Cell col=\"4\" text=\"??????\"/><Cell col=\"5\" text=\"????????????\"/><Cell col=\"6\" text=\"??????\"/><Cell col=\"7\" text=\"????????????\"/><Cell col=\"8\" text=\"??????\"/><Cell col=\"9\" text=\"??????\"/></Band><Band id=\"body\"><Cell text=\"bind:chk\" displaytype=\"checkboxcontrol\" edittype=\"checkbox\" expr=\"expr:chk==&apos;Y&apos;?&apos;1&apos;:&apos;0&apos;\" textAlign=\"center\"/><Cell col=\"1\" text=\"bind:scholarship_avg_grade\" textAlign=\"center\"/><Cell col=\"2\" text=\"bind:scholarship_year\" textAlign=\"center\"/><Cell col=\"3\" text=\"bind:scholarship_term\" textAlign=\"center\"/><Cell col=\"4\" text=\"expr:scholarship_status == &apos;Y&apos;? &quot;??????&quot; : scholarship_status== &apos;N&apos;? &quot;?????????&quot; : scholarship_status == &apos;W&apos;? &quot;??????&quot; : &quot;&quot;\" textAlign=\"center\"/><Cell col=\"5\" text=\"bind:scholarship_amount\" textAlign=\"center\"/><Cell col=\"6\" text=\"bind:scholarship_name\" textAlign=\"center\"/><Cell col=\"7\" text=\"bind:scholarship_phonenumber\" textAlign=\"center\"/><Cell col=\"8\" text=\"bind:scholarship_college\" textAlign=\"center\"/><Cell col=\"9\" text=\"bind:scholarship_student_no\" textAlign=\"center\"/></Band></Format></Formats>");
            this.addChild(obj.name, obj);

            obj = new Static("Static00_00","30","83","60","30",null,null,null,null,null,null,this);
            obj.set_taborder("8");
            obj.set_text("??????");
            obj.set_font("normal bold 10pt/normal \"Arial\"");
            this.addChild(obj.name, obj);

            obj = new Div("Div03","0","65","800","5",null,null,null,null,null,null,this);
            obj.set_taborder("9");
            obj.set_text("");
            obj.set_background("rgba(16, 65, 44, 0.2)");
            obj.set_border("0");
            obj.set_color("transparent");
            this.addChild(obj.name, obj);

            obj = new Static("Static00_02","40","15","219","30",null,null,null,null,null,null,this);
            obj.set_taborder("10");
            obj.set_text("????????? ??????");
            obj.set_font("normal bold 10pt/normal \"Arial\"");
            this.addChild(obj.name, obj);

            obj = new Div("Div01_00_00","18","18","5","25",null,null,null,null,null,null,this);
            obj.set_taborder("11");
            obj.set_text("");
            obj.set_background("rgb(0, 74, 38)");
            this.addChild(obj.name, obj);

            obj = new Static("Static00_00_00","199","83","60","30",null,null,null,null,null,null,this);
            obj.set_taborder("12");
            obj.set_text("??????");
            obj.set_font("normal bold 10pt/normal \"Arial\"");
            this.addChild(obj.name, obj);

            obj = new Static("Static00_00_00_00","370","83","60","30",null,null,null,null,null,null,this);
            obj.set_taborder("13");
            obj.set_text("??????");
            obj.set_font("normal bold 10pt/normal \"Arial\"");
            this.addChild(obj.name, obj);
            // Layout Functions
            //-- Default Layout : this
            obj = new Layout("default","",800,600,this,function(p){});
            this.addLayout(obj.name, obj);
            
            // BindItem Information

            
            // TriggerItem Information

        };
        
        this.loadPreloadList = function()
        {

        };
        
        // User Script
        this.registerScript("scholarship_info.xfdl", function() {

         this.scholarship_info_onload = function(obj,e)
         {

        };



        this.ds_scholarship_oncolumnchanged = function(obj,e)
        {
        	 if(e.columnid == "chk") {
        		obj.enableevent = false;
        			if(e.newvalue == '1') {
        				obj.setColumn(e.row,"chk",'Y');
        	  } else if(e.newvalue == '0') {
        		obj.setColumn(e.row,"chk",'N');
        		}
        		obj.enableevent = true;
        	}


        };
        this.year = "";
        this.term  = "";
        this.departmentName = "";
        this.btnCheck_onclick = function(obj,e)
        {
        	year = this.Combo00.text;
        	term = this.Combo01.text;
        	departmentName= this.Combo02.text;
        	this.ds_send.setColumn(0, 0, this.Combo00.text);
        	this.ds_send.setColumn(0, 1, this.Combo01.text);
        	this.ds_send.setColumn(0, 2, this.Combo02.text);
        	this.resultInfo();
        };

        this.resultInfo = function(){
        	this.transaction(
         		"scholarship_resultinfo"// 1.ID
         		,"CmURL::scholarship/scholarInfo.kh"// 2.URL
         		,"in_scholar = ds_send" // 3.InDs : F->S jsp(I,U,D)
         		,"ds_scholarship=out_scholarship" // 4.OutDs : S->F jsp(SELECT)
         		,"" // 5.InVar : F->S(var)
        		,"fn_callback_tran" // 6.callback function(transaction ????????? ???????????? ??????)
         	);
        }


        this.btn_accept_onclick = function(obj,e)
        {

        		this.transaction(
         		"scholarship_acceptInfo"// 1.ID
         		,"CmURL::scholarship/scholarAccept.kh"// 2.URL
         		,"ins_scholarship=ds_scholarship:U" // 3.InDs : F->S jsp(I,U,D)
         		,"" // 4.OutDs : S->F jsp(SELECT)
         		,"" // 5.InVar : F->S(var)
        		,"fn_callback_tran" // 6.callback function(transaction ????????? ???????????? ??????)
        		);
        };




        this.btn_denined_onclick = function(obj,e)
        {

        		this.transaction(
         		"scholarship_denineInfo"// 1.ID
         		,"CmURL::scholarship/scholarDenine.kh"// 2.URL
         		,"ins_scholarship=ds_scholarship:U" // 3.InDs : F->S jsp(I,U,D)
         		,"" // 4.OutDs : S->F jsp(SELECT)
         		,"" // 5.InVar : F->S(var)
        		,"fn_callback_tran" // 6.callback function(transaction ????????? ???????????? ??????)
        		);
        };



        this.fn_callback_tran = function(id, nErrorCode, sErrorMsg, sSuccessMsg)
        {
        	if(id == "scholarship_resultinfo")
        	{
        		if(nErrorCode < 0)
        		{

        			return;
        		}else{

        		if(this.ds_send.getColumn(0,0) != ""&& this.ds_send.getColumn(0,1) != "" && this.ds_send.getColumn(0,2) != "") {
        			this.Combo00.set_text(year);
        			this.Combo01.set_text(term);
        			this.Combo02.set_text(departmentName);

        		}else{

        		}

        		return ;
        		}
        	}

        	else if(id == "scholarship_acceptInfo")
        	{
        		if(nErrorCode < 0)
        		{

        			return;
        		}else{
        		this.resultInfo();
        		return ;
        	}
        	}

        	else if(id == "scholarship_denineInfo")
        	{
        		if(nErrorCode < 0)
        		{

        			return;
        		}else{
        		this.resultInfo();
        		return ;
        	}
        	}


        };






        });
        
        // Regist UI Components Event
        this.on_initEvent = function()
        {
            this.addEventHandler("onload",this.scholarship_info_onload,this);
            this.btnCheck.addEventHandler("onclick",this.btnCheck_onclick,this);
            this.Combo00.addEventHandler("onitemchanged",this.Combo00_onitemchanged,this);
            this.Combo01.addEventHandler("onitemchanged",this.Combo01_onitemchanged,this);
            this.btn_accept.addEventHandler("onclick",this.btn_accept_onclick,this);
            this.btn_denined.addEventHandler("onclick",this.btn_denined_onclick,this);
            this.Grid00.addEventHandler("oncellclick",this.Grid00_oncellclick,this);
            this.ds_scholarship.addEventHandler("oncolumnchanged",this.ds_scholarship_oncolumnchanged,this);
        };
        this.loadIncludeScript("scholarship_info.xfdl");
        this.loadPreloadList();
        
        // Remove Reference
        obj = null;
    };
}
)();
