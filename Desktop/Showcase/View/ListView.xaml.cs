using System.Windows;
using System.Windows.Controls;
using System.Windows.Input;

namespace Showcase.View
{
    /// <summary>
    /// Interaction logic for ListView.xaml
    /// </summary>
    /// 
    public partial class ListView : Window
    {

        public ListView()
        {
            InitializeComponent();
        }

        private void AddItem(object sender, RoutedEventArgs e)
        {
            VM.AddItem();
        }
        private void RemoveItem(object sender, RoutedEventArgs e)
        {
            VM.RemoveItem();
        }

        private void DataGridRow_PreviewMouseLeftButtonDown(object sender, MouseButtonEventArgs e)
        {
            var row = sender as DataGridRow;
            if (row == null) return;
            if (!row.IsSelected)
            {
                row.IsSelected = true;
            }
        }

        private void TextBox_KeyDown(object sender, KeyEventArgs e)
        {
            if (e.Key == Key.Enter)
            {
                AddItem(null, null);
                e.Handled = true;
            }
        }
    }
}
