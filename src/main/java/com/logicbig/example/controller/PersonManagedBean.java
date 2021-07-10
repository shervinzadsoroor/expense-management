package com.logicbig.example.controller;

import com.logicbig.example.model.Person;
import com.logicbig.example.repository.IPersonDao;
import com.logicbig.example.service.PersonLazyDataModel;
import com.logicbig.example.service.PersonService;
import lombok.Getter;
import lombok.Setter;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.primefaces.event.CellEditEvent;
import org.primefaces.event.RowEditEvent;
import org.primefaces.model.LazyDataModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.el.MethodExpression;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

@Component
@ManagedBean
@RequestScoped
public class PersonManagedBean {

    @Autowired
    private IPersonDao iPersonDao;

    @Getter
    @Setter
    private PersonLazyDataModel personLazyDataModel = new PersonLazyDataModel(iPersonDao);

    @Getter
    private List<Person> people;

    @Getter
    @Setter
    private List<Person> selectedPeople;

    @Getter
    private List<Person> selectionOfPeople;

    private final PersonService personService;

    public PersonManagedBean(PersonService personService) {
        this.personService = personService;
    }

    @PostConstruct
    public void init() {
        this.people = personService.getAllPeople();
        selectionOfPeople = new ArrayList<>();
        personLazyDataModel = new PersonLazyDataModel(iPersonDao);
    }

    public void showLazyData() {
//        personLazyDataModel.load()
    }

    public void showSelectedPeople() {
        selectionOfPeople.addAll(selectedPeople);
        System.out.println("selectedPeople = " + selectionOfPeople);
    }

    public void onEditInit(RowEditEvent event) {
        System.out.println("onEditInit: " + event.getObject());
    }

    public void onRowEdit(RowEditEvent<Person> event) {
        FacesMessage msg = new FacesMessage("person Edited",
                String.valueOf(event.getObject().getFirstName()));
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public void onRowCancel(RowEditEvent<Person> event) {
        FacesMessage msg = new FacesMessage("Edit Cancelled",
                String.valueOf(event.getObject().getFirstName()));
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public void onCellEdit(CellEditEvent event) {
        Object oldValue = event.getOldValue();
        Object newValue = event.getNewValue();

        if (newValue != null && !newValue.equals(oldValue)) {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Cell Changed", "Old: " + oldValue + ", New:" + newValue);
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }
    }

    public void validateNationalCode(FacesContext context, UIComponent comp, Object value) {
        System.out.println("inside validate method");
        String mno = (String) value;
        if (mno.length() < 4) {
            ((UIInput) comp).setValid(false);
            FacesMessage message = new FacesMessage(
                    "Minimum length of model number is 4");
            context.addMessage(comp.getClientId(context), message);
        }
    }

    public void fromValidator(FacesContext context, UIComponent comp, Object value) {
        Long from = (Long) value;
        UIInput uiInput = (UIInput) comp;
        Long accessKey = (Long) uiInput.getAttributes().get("accesskey");
        if (from < 1) {
            uiInput.setValid(false);
            FacesMessage message = new FacesMessage(
                    "مقدار 'از' نمیتواند کمتر از صفر باشد");
            context.addMessage(comp.getClientId(context), message);
        }
    }

    public void toValidator(FacesContext context, UIComponent comp, Object value) {
        System.out.println("inside validate method");
        String mno = (String) value;
        if (mno.length() < 4) {
            ((UIInput) comp).setValid(false);
            FacesMessage message = new FacesMessage(
                    "Minimum length of model number is 4");
            context.addMessage(comp.getClientId(context), message);
        }
    }

    public void downloadExcel() throws IOException {

        File file = new File("F:\\projects\\boot-primefaces-integration-example\\src\\main\\resources\\test.xlsx");
        FacesContext facesContext = FacesContext.getCurrentInstance();
        HttpServletResponse response = (HttpServletResponse) facesContext.getExternalContext().getResponse();

        response.reset();
        response.setHeader("Content-Type", "application/octet-stream");
        response.setHeader("Content-Disposition", "attachment;filename=poiTesting.xlsx");

        OutputStream responseOutputStream = response.getOutputStream();
        InputStream fileInputStream = new FileInputStream(file);

        byte[] bytesBuffer = new byte[2048];
        int bytesRead;
        while ((bytesRead = fileInputStream.read(bytesBuffer)) > 0) {
            responseOutputStream.write(bytesBuffer, 0, bytesRead);
        }

        responseOutputStream.flush();
        fileInputStream.close();
        responseOutputStream.close();
        facesContext.responseComplete();

    }

    public void downloadExcelOnFly() throws IOException {

        ByteArrayOutputStream baos = new ByteArrayOutputStream();

        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("sheet1");
        Row row = sheet.createRow(0);
        Cell cell = row.createCell(0);
        cell.setCellValue("ali");
        workbook.write(baos);

        FacesContext facesContext = FacesContext.getCurrentInstance();
        HttpServletResponse response = (HttpServletResponse) facesContext.getExternalContext().getResponse();

        response.reset();
        response.setHeader("Content-Type", "application/octet-stream");
        response.setHeader("Content-Disposition", "attachment;filename=test.xlsx");

        OutputStream responseOutputStream = response.getOutputStream();
        responseOutputStream.write(baos.toByteArray());
        responseOutputStream.flush();
        workbook.close();
        responseOutputStream.close();
        facesContext.responseComplete();

    }

    public String[] getOptions() {
        return new String[]{"Option 1", "Option 2", "Option 3"};
    }
}
