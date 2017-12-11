import { async, ComponentFixture, TestBed } from '@angular/core/testing';
import { FormsModule } from '@angular/forms';
import { By } from '@angular/platform-browser';
import { HttpModule } from '@angular/http';
import { RouterTestingModule } from '@angular/router/testing';
import { NO_ERRORS_SCHEMA } from '@angular/core';

import { NavComponent } from './nav.component';

function login(){
  localStorage.setItem('token','testToken')
}

function logout(){
  localStorage.removeItem('token');
}

describe('NavComponent', () => {
  let component: NavComponent;
  let fixture: ComponentFixture<NavComponent>;
  let ulElement;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      imports: [FormsModule, HttpModule, RouterTestingModule],
      declarations: [ NavComponent ],
      schemas: [NO_ERRORS_SCHEMA]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(NavComponent);
    component = fixture.componentInstance;
    ulElement = fixture.debugElement.queryAll(By.css('ul'));
    // fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });

  it(`should have nav element`, async(() => {
    const navElement = fixture.debugElement.queryAll(By.css('nav'));
    expect(navElement.length).toBe(1);
  }));

  it(`should have anchor element`, async(() => {
    const anchorElement = fixture.debugElement.queryAll(By.css('a'));
    expect(anchorElement).toBeTruthy();
  }));

  it(`should have 2 unordered list elements`, async(() => {
    expect(ulElement.length).toBe(2);
  }));

  it(`should have 1 list item in first unordered list element if user is not logged in.`, async(() => {
    logout();
    fixture.detectChanges();
    const liElements = ulElement[0].queryAll(By.css('li'));
    expect(liElements.length).toBe(1);
  }));

  it(`should have 2 list item in first unordered list element if user is logged in.`, async(() => {
    login();
    fixture.detectChanges();
    const liElements = ulElement[0].queryAll(By.css('li'));
    expect(liElements.length).toBe(2);
  }));

  it(`should have 2 list item in second unordered list element if user is not logged in.`, async(() => {
    logout();
    fixture.detectChanges();
    const liElements = ulElement[1].queryAll(By.css('li'));
    expect(liElements.length).toBe(2);
  }));

  it(`should have 1 list item in second unordered list element if user is logged in.`, async(() => {
    login();
    fixture.detectChanges();
    const liElements = ulElement[1].queryAll(By.css('li'));
    expect(liElements.length).toBe(1);
  }));

  it(`should have Login Modal`, async(() => {
    const loginModal = fixture.debugElement.query(By.css('#loginModal'));
    expect(loginModal).toBeTruthy();
  }));

  it(`should have Signup Modal`, async(() => {
    const signupModal = fixture.debugElement.query(By.css('#signupModal'));
    expect(signupModal).toBeTruthy();
  }));

  describe('Login Modal', () => {
    let loginNativeElements;
    let loginHeadingElement;
    let loginFormElement;
    let loginInputElement;
    let loginbuttonElement;

    beforeEach(() => {
      loginNativeElements = fixture.debugElement.query(By.css('#loginModal'));
      loginHeadingElement = loginNativeElements.queryAll(By.css('h4'));
      loginFormElement = loginNativeElements.query(By.css('form'));
      loginInputElement = loginNativeElements.queryAll(By.css('input'));
      loginbuttonElement = loginNativeElements.queryAll(By.css('button'));
    });

    it(`should have 1 heading`, async(() => {
      expect(loginHeadingElement.length).toBe(1);
    }));

    it(`should have heading text "Login"`, async(() => {
      expect(loginHeadingElement[0].nativeElement.innerHTML.trim()).toBe('Login');
    }));

    it(`should have Form Element`, async(() => {
      expect(loginFormElement).toBeTruthy();
    }));

    it(`should have 2 input fields for Username & Password`, async(() => {
      expect(loginInputElement.length).toBe(2);
    }));

    it(`should have 3 button fields`, async(() => {
      expect(loginbuttonElement.length).toBe(3);
    }));

    it(`first button should have button text "×"`, async(() => {
      expect(loginbuttonElement[0].nativeElement.innerHTML.trim()).toBe('×');
    }));

    it(`second button should have button text "Login"`, async(() => {
      expect(loginbuttonElement[1].nativeElement.innerHTML.trim()).toBe('Login');
    }));

    it(`third button should have button text "Cancel"`, async(() => {
      expect(loginbuttonElement[2].nativeElement.innerHTML.trim()).toBe('Cancel');
    }));
  });

  describe('Register Modal', () => {
    let registerNativeElements;
    let registerHeadingElement;
    let registerFormElement;
    let registerInputElement;
    let registerbuttonElement;

    beforeEach(() => {
      registerNativeElements = fixture.debugElement.query(By.css('#signupModal'));
      registerHeadingElement = registerNativeElements.queryAll(By.css('h4'));
      registerFormElement = registerNativeElements.query(By.css('form'));
      registerInputElement = registerNativeElements.queryAll(By.css('input'));
      registerbuttonElement = registerNativeElements.queryAll(By.css('button'));
    });

    it(`should have 1 heading`, async(() => {
      expect(registerHeadingElement.length).toBe(1);
    }));

    it(`should have heading text "Sign Up"`, async(() => {
      expect(registerHeadingElement[0].nativeElement.innerHTML.trim()).toBe('Sign Up');
    }));

    it(`should have Form Element`, async(() => {
      expect(registerFormElement).toBeTruthy();
    }));

    it(`should have 4 input fields for Firstname, Lastname, Username & Password`, async(() => {
      expect(registerInputElement.length).toBe(4);
    }));

    it(`should have 3 button fields`, async(() => {
      expect(registerbuttonElement.length).toBe(3);
    }));

    it(`first button should have button text "×"`, async(() => {
      expect(registerbuttonElement[0].nativeElement.innerHTML.trim()).toBe('×');
    }));

    it(`second button should have button text "Sign Up"`, async(() => {
      expect(registerbuttonElement[1].nativeElement.innerHTML.trim()).toBe('Sign Up');
    }));

    it(`third button should have button text "Cancel"`, async(() => {
      expect(registerbuttonElement[2].nativeElement.innerHTML.trim()).toBe('Cancel');
    }));
  });

});
