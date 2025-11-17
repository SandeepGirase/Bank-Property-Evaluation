import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-evaluation-form',
  standalone: true,
  imports: [CommonModule, FormsModule],
  template: `
    <section>
      <h2>Start Property Evaluation</h2>
      <form (ngSubmit)="submit()">
        <label>Address<br /><input name="address" [(ngModel)]="model.address" /></label>
        <br />
        <label>Estimated Value<br /><input name="value" type="number" [(ngModel)]="model.value" /></label>
        <br />
        <button type="submit">Submit</button>
      </form>
      <pre *ngIf="submitted">{{model | json}}</pre>
    </section>
  `
})
export class EvaluationFormComponent {
  model = { address: '', value: null } as any;
  submitted = false;
  submit() {
    this.submitted = true;
  }
}
