export interface Transaction {
  id: string
  sender_account_id: Object
  receiver_account_id: Object
  dateTime: number
  amount: number
}
