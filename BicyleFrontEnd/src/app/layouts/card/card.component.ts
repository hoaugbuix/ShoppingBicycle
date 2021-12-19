import { Component, Input, OnChanges, OnInit, SimpleChanges } from '@angular/core';

@Component({
  selector: 'app-card',
  templateUrl: './card.component.html',
  styleUrls: ['./card.component.scss']
})
export class CardComponent implements OnInit, OnChanges {

  @Input() dataSend?: any = [];
  lstData: any = [];

  constructor() { }
  ngOnChanges(changes: SimpleChanges): void {
    // console.log(changes['dataSend'].currentValue);

  }

  ngOnInit(): void {
  }

}
